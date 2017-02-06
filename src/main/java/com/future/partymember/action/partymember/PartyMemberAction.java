package com.future.partymember.action.partymember;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.ExamLog;
import com.future.partymember.entity.ExamPerRecord;
import com.future.partymember.entity.Inform;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.Question;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.entity.StartTest;
import com.future.partymember.entity.WatchVideoRecord;
import com.future.partymember.util.PageCut;
import com.future.partymember.util.PaperUtil;
import com.future.partymember.util.SwitchTime;

/*
 * 党员信息控制层
 * @author 焦祥宇
 */
public class PartyMemberAction extends BaseAction {
	/**
	 * +
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int page = 1;

	/**
	 * 下面两行添加人 丁赵雷
	 */
	private PageCut<?> pageCut; // 封装分页信息的
	private Inform inform;// 用来封装通知消息的

	private PartyMemberInfo partyMemberInfo;// 从表单获得党员对象
	
	
	// 查询党员个人信息
	public String seekPartyMemberInfo() throws Exception {
		int userId=(Integer)this.getSession().get("userId");
		partyMemberInfo = partyMemberInfoService.getPartyMemberInfoById(userId);
		// 学习时间
		String time = SwitchTime.switchTime(partyMemberInfo.getLearnTime());
		this.getRequest().setAttribute("learnTime", time);
		this.getRequest().setAttribute("partyMember", partyMemberInfo);
		return "seekPartyMemberInfo";
	}

	// 修改党员个人信息时，先获得党员信息以便修改
	public String getInfoBeforeUpdate() throws Exception {
		/*partyMemberInfo = partyMemberInfoService.getPartyMemberInfoById(1);
		String time = SwitchTime.switchTime(partyMemberInfo.getLearnTime());
		this.getRequest().setAttribute("learnTime", time);
		this.getSession().put("partyMember", partyMemberInfo);*/
		return "getInfoBeforeUpdate";
	}

	// 修改党员个人基本信息
	public String updatePartyMemberInfo() throws Exception {
		int judge=Integer.valueOf(this.getRequest().getParameter("judge"));
		int userId =(Integer)this.getSession().get("userId");
		PartyMemberInfo partyMemberInfo=partyMemberInfoService.getPartyMemberInfoById(userId);
		if(judge==1){//修改密码
			// 密码加密还没加
			String password =this.getRequest().getParameter("newPassword");
			partyMemberInfo.setPassword(password);
		}
		else if(judge==2){
			String phoneNum =this.getRequest().getParameter("newPhoneNum");
			partyMemberInfo.setPhoneNo(phoneNum);
		}			
		Boolean bool = partyMemberInfoService.updatePartyMemberInfo(partyMemberInfo);
		if (bool == true) {
			this.getRequest().setAttribute("updateMsg", "修改成功");
		} else {
			this.getRequest().setAttribute("updateMsg", "修改失败");
		}
		return "updatePartyMemberInfo";
	}

	// 红色视频
	public String viewVideos() throws Exception {
		PageCut<RedVideo> pc = redVideoService.getPC(16,page );		
		this.getRequest().setAttribute("pc", pc);		
		return "viewVideos";
	}

	/**
	 * 看视频 ---丁赵雷修改 2017-01-14
	 * 
	 * @return
	 * @throws Exception
	 *             第二次修改 ----丁赵雷 2017-01-26
	 */
	public String viewing() throws Exception {
		// 从路径获得视频id
		int videoId = Integer.valueOf(this.getRequest().getParameter("rv_Id"));
		int userId=(Integer)this.getSession().get("userId");
		// 获得视频观看记录
		WatchVideoRecord watchVideoRecord = watchVideoRecordService.getWVR(videoId, userId, 0);
		if (watchVideoRecord != null)
			this.getRequest().setAttribute("currentTime", watchVideoRecord.getCurrentTime());
		// 视频浏览次数加一
		redVideoService.updatewatchNumById(videoId);

		// 播放视频
		RedVideo redVideo = redVideoService.get(videoId);

		this.getRequest().setAttribute("video", redVideo);
		
		//查询第一个和最后一个视频作为临界点
				RedVideo lastVideo=redVideoService.getLastRecordById().get(0);
				RedVideo fristVideo=redVideoService.getFristRecordById().get(0);
				
				//查询上一个 下一个
				if(lastVideo.getRv_Id()==videoId){
					this.getRequest().setAttribute("next", lastVideo);
					this.getRequest().setAttribute("notice", "后面没有了");			
				}else{
					List<RedVideo> rvNext=redVideoService.getNextRecordById(videoId);
					RedVideo rv1=rvNext.get(0);
					this.getRequest().setAttribute("next",rv1 );
				}
				
				if(fristVideo.getRv_Id()==videoId){
					this.getRequest().setAttribute("prev", fristVideo);
					this.getRequest().setAttribute("notice", "前面没有了");
				}else{
					List<RedVideo> rpPrev=redVideoService.getPrevRecordById(videoId);
					RedVideo rv2=rpPrev.get(0);
					this.getRequest().setAttribute("prev", rv2);
				}

		return "viewing";
	}
	
	/**
	 * 更新党员的学习时间和视频播放记录历史 丁赵雷 ---焦祥宇修改过
	 */
	public void updateLearnTime() throws Exception {
		int userId=(Integer)this.getSession().get("userId");// 用户id
		partyMemberInfo = partyMemberInfoService.getPartyMemberInfoById(userId);
		long time = Integer.parseInt(getRequest().getParameter("time"));		
		time = time + partyMemberInfo.getLearnTime();
		String strTime = SwitchTime.switchTime(time);
		System.out.println("time="+time);
		System.out.println("strtime="+strTime);
		partyMemberInfo.setLearnTime(time);				
		partyMemberInfo.setStrLearnTime(strTime);
		partyMemberInfoService.updatePartyMemberInfo(partyMemberInfo);
		// 视频播放记录历史
		
		String vt = getRequest().getParameter("currentTime");
		long currentTime = 0;
		if (vt.indexOf(".") > 0) {
			currentTime = Integer.valueOf(vt.substring(0, vt.indexOf(".")));
		} else {
			currentTime = Integer.valueOf(vt);
		}
		int videoId = Integer.valueOf(getRequest().getParameter("videoId"));
		WatchVideoRecord watchVideoRecord;
		watchVideoRecord = watchVideoRecordService.getWVR(videoId, userId, 0);

		System.out.println("watchVideoRecord="+watchVideoRecord);
		if (watchVideoRecord == null) {
			watchVideoRecord = new WatchVideoRecord();
			watchVideoRecord.setRv_id(videoId);
			watchVideoRecord.setPm_id(userId);
			watchVideoRecord.setCurrentTime(currentTime);
			watchVideoRecordService.addWVR(watchVideoRecord);
		} else {
			watchVideoRecord.setRv_id(videoId);
			watchVideoRecord.setPm_id(userId);
			watchVideoRecord.setCurrentTime(currentTime);
			watchVideoRecordService.updateWVR(watchVideoRecord);
		}
	}

	/**
	 * @author 丁赵雷 根据名字模糊查询视频
	 */
	public String findByName() throws Exception {
		String name = this.getRequest().getParameter("videoName"); // 视频名字
		PageCut<RedVideo> pc = redVideoService.getPC(12, page);
		System.out.println("模糊查询视频");
		this.getRequest().setAttribute("pc", pc);
		List<RedVideo> videosList = redVideoService.findByName(name);
		this.getRequest().setAttribute("videosList", videosList);
		return "viewVideos";
	}

	// 链接到红色文章
	public String getResPaper() throws Exception {
		List<RedPaper> paperList = redPaperService.findPaperByType();
		paperList = PaperUtil.titleLength(paperList, 16);
		this.getRequest().setAttribute("paperList", paperList);
		return "getResPaper";
	}

	// 进入某个文章版块的列表 如党建巡礼的文章列表
	public String paperSection() {
		String search=this.getRequest().getParameter("search");
		int paperTypeId=Integer.parseInt(this.getRequest().getParameter("paperTypeId"));
		pageCut=redPaperService.getPCByNew(page, 15, paperTypeId , search);
		this.getRequest().setAttribute("pc", pageCut);
		this.getRequest().setAttribute("paper", pageCut.getData().get(0));
		return "paperSection";
	}

	// 阅读文章
	public String lookPaper() throws Exception {
		int id = Integer.parseInt(this.getRequest().getParameter("rp_Id"));
		redPaperService.updatePaperReadNum(id);// 文章阅读次数加一
		RedPaper rp = redPaperService.getById(id);
		this.getRequest().setAttribute("paper", rp);

		// 查询第一篇 最后一篇 作为临界点
		RedPaper lastPaper = redPaperService.getLastRecordById(rp.getPaperTypeId()).get(0);
		RedPaper fristPaper = redPaperService.getFristRecordById(rp.getPaperTypeId()).get(0);

		// 查询上一篇 下一篇
		if (lastPaper.getRp_Id() == id) {
			this.getRequest().setAttribute("next", lastPaper);
			this.getRequest().setAttribute("notice", "后面没有了");
		} else {
			List<RedPaper> rpNext = redPaperService.getNextRecordById(id, rp.getPaperTypeId());
			if (rpNext != null) {
				RedPaper rp1 = rpNext.get(0);
				this.getRequest().setAttribute("next", rp1);
			}
		}

		if (fristPaper.getRp_Id() == id) {
			this.getRequest().setAttribute("prev", fristPaper);
			this.getRequest().setAttribute("notice", "前面没有了");
		} else {
			List<RedPaper> rpPrev = redPaperService.getPrevRecordById(id, rp.getPaperTypeId());
			RedPaper rp2 = rpPrev.get(0);
			this.getRequest().setAttribute("prev", rp2);
		}

		return "lookPaper";
	}

	// 在线考试
	public String startTest() throws Exception {
		StartTest startTest = (StartTest) this.getRequest().getSession().getServletContext().getAttribute("startTest");
		if (startTest != null) {
			if (SwitchTime.strToTime(startTest.getEndTime()).after(new Date())) {
				List<Question> questionsList = questionService.getQuestionsByTpId(startTest.getTestPaper().getTp_Id());

				// 计算考试时长和总分
				int totalScore = 0;
				for (Question q : questionsList) {
					totalScore += q.getQuestion_socre();
				}
				startTest.setTotalScore(totalScore);
				startTest.setTestNum(questionsList.size());
				this.getSession().put("questionsList", questionsList);
				long time=SwitchTime.strToTime(startTest.getEndTime()).getTime();
				
				System.out.println("考试结束时间："+time);
				this.getSession().put("time", time);
			} else {
				this.getRequest().setAttribute("NoTest", "暂时没有考试！");
			}
		} else {
			this.getRequest().setAttribute("NoTest", "暂时没有考试！");
		}
		return "startTest";
	}

	// 考试提交
	public String getExamRecord() throws Exception {
		StartTest startTest = (StartTest) this.getRequest().getSession().getServletContext().getAttribute("startTest");
		if (SwitchTime.strToTime(startTest.getEndTime()).after(new Date())) {
			// 考试记录详情集合
			List<ExamPerRecord> examPerRecordList = new ArrayList<ExamPerRecord>();
			// 考试的试卷信息

			int tp_Id = startTest.getTestPaper().getTp_Id();// 试卷id
			int st_Id = startTest.getSt_Id();// 开启试卷记录id
			String paperName = startTest.getPaperName();// 试卷名称
			int testNum = startTest.getTestNum();// 题数
			int testTotalScore = startTest.getTotalScore();// 试卷总分
			String testTime = startTest.getTestTime();// 考试时长

			// 试题集合
			@SuppressWarnings("unchecked")
			List<Question> questionsList = (List<Question>) this.getSession().get("questionsList");
			int totalScore = 0;// 总成绩
			int userId = (Integer) this.getSession().get("userId");// 用户id
			int userSort = (Integer) this.getSession().get("userSort");// 用户身份
			for (int i = 0; i < testNum; i++) {
				String str = (String) this.getRequest().getParameter("answer" + i);
				String userAnswer = ((Character) str.charAt(0)).toString();// 考生答案
				int qt_Id = Integer.valueOf(str.substring(1));// 试题id
				int score = 0;// 该题得分
				Question question = (Question) questionsList.toArray()[i];// 该题信息
				if (userAnswer.equals(questionService.getAnswersByQtId(qt_Id).getAnswer())) {
					score = question.getQuestion_socre();
					totalScore += score;
				}
				ExamPerRecord examPerRecord = new ExamPerRecord(tp_Id, qt_Id, userAnswer, score, userId, userSort);
				examPerRecordList.add(examPerRecord);
			}
			String partyMemberName = partyMemberInfoService.getPartyMemberInfoById(userId).getUsername();
			String partyBranch=partyMemberInfoService.getPartyMemberInfoById(userId).getPartyBranch();
			String date = SwitchTime.dateToTimeStr(new Date());
			ExamLog examLog = new ExamLog(st_Id, tp_Id, paperName, userId, partyMemberName,partyBranch, userSort, totalScore, date,
					testTime, testTotalScore, testNum);

			int wetherAdd = examLogService.grtElIdByDate(st_Id);
			System.out.println("examLog wetherAdd="+wetherAdd);
			if (wetherAdd == 0) {
				Boolean bool = examLogService.addExamLog(examLog);
				if (bool == true) {
					int el_Id = examLogService.grtElIdByDate(st_Id);
					for (ExamPerRecord e : examPerRecordList) {
						e.setEl_Id(el_Id);
						// 保存考试详细记录
						examPerRecordService.addExamPerRecord(e);
					}
					this.getRequest().setAttribute("addExamLogMsg", "提交成功！");
				} else {
					this.getRequest().setAttribute("addExamLogMsg", "提交失败！");
				}
			} else {
				this.getRequest().setAttribute("addExamLogMsg", "已提交！");
			}
		} else {
			this.getRequest().setAttribute("addExamLogMsg", "考试时间已过不能提交！");
		}
		return "getExamRecord";
	}

	// 查看考试记录
	public String getMyExamLog() throws Exception {
		int userId = (Integer) this.getSession().get("userId");
		int userSort = (Integer) this.getSession().get("userSort");
		PageCut<ExamLog> pc = examLogService.getExamLogsBypartyMemberId(page, 8, userId, userSort);
		this.getRequest().setAttribute("pc", pc);
		List<ExamLog> examLogList = pc.getData();
		if (examLogList.size() > 0) {
			this.getSession().put("examLogList", examLogList);
		} else {
			this.getRequest().setAttribute("myExamLogMsg", "暂时没有考试报告！");
		}

		return "getMyExamLog";
	}

	// 查看考试记录详情
	public String getExamDetails() throws Exception {
		int userId = (Integer) this.getSession().get("userId");
		int userSort = (Integer) this.getSession().get("userSort");
		int tp_Id = Integer.valueOf(this.getRequest().getParameter("tp_Id"));
		int el_Id = Integer.valueOf(this.getRequest().getParameter("el_Id"));
		int st_Id = Integer.valueOf(this.getRequest().getParameter("st_Id"));
		List<ExamPerRecord> examPerRecordsList = examPerRecordService.getExamPerRecordsByUserId(userId, tp_Id, el_Id,
				userSort);
		List<Question> questionsList = new ArrayList<>();
		for (ExamPerRecord e : examPerRecordsList) {
			Question question = questionService.getQuestionByQtId(e.getQt_Id());
			if (!question.getAnswer().equals(e.getAnswer())) {
				question.setMyAnswer(e.getAnswer());
			}
			question.setMyScore(e.getSocre());
			questionsList.add(question);
		}
		ExamLog examLog = examLogService.getExamLogByTpId(userId, userSort, tp_Id, st_Id);
		this.getRequest().setAttribute("examLog", examLog);
		this.getRequest().setAttribute("questionsList", questionsList);
		return "getExamDetails";
	}
	
	/**通知列表
	 * 查看通知
	 * 这个两个方法   
	 * 
	 * 丁赵雷添加
	 * @return
	 */
	
	//通知列表
	public String informList(){				
		PageCut<Inform> pc=informService.getInformList(page, 5, 2,3);//2 3 代表通知的权限
		if(pc.getData().size()==0){
			this.getRequest().setAttribute("informMsg", "暂时没有通知！");
		}
		else{			
			this.getRequest().setAttribute("pc", pc);
		}
		return "informList";
	}
	
	//查看通知
	public String lookInform(){
		if(inform.getInfo_Id()!=0){
			Inform i=informService.getById(inform.getInfo_Id());
			this.getRequest().setAttribute("inform", i);
		}
		
		return "lookInform";
	}
	/*
	 * //查询个人党费交纳
	 * 
	 * public String getPartyFree(){
	 * 
	 * return "getPartyFree"; }
	 */
	public String connectUs() throws Exception{
		return "connectUs";
	}
	
	public void setPartyMemberInfo(PartyMemberInfo partyMemberInfo) {
		this.partyMemberInfo = partyMemberInfo;
	}

	public PartyMemberInfo getPartyMemberInfo() {
		return partyMemberInfo;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageCut<?> getPageCut() {
		return pageCut;
	}

	public void setPageCut(PageCut<?> pageCut) {
		this.pageCut = pageCut;
	}

	public Inform getInform() {
		return inform;
	}

	public void setInform(Inform inform) {
		this.inform = inform;
	}

}
