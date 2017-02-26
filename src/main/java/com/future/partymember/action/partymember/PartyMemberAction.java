package com.future.partymember.action.partymember;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.ExamLog;
import com.future.partymember.entity.ExamPerRecord;
import com.future.partymember.entity.IndexImage;
import com.future.partymember.entity.Inform;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.Question;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.entity.RedPaperType;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.entity.StartTest;
import com.future.partymember.entity.WatchVideoRecord;
import com.future.partymember.util.PageCut;
import com.future.partymember.util.PaperUtil;
import com.future.partymember.util.SwitchTime;

import javafx.scene.control.Toggle;

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
			
			String password =this.getRequest().getParameter("newPassword");
			partyMemberInfo.setPassword(password);
		}
		else if(judge==2){
			String phoneNum =this.getRequest().getParameter("newPhoneNum");
			partyMemberInfo.setPhoneNo(phoneNum);
		}			
		Boolean bool = partyMemberInfoService.updatePartyMemberInfo(partyMemberInfo);
		if (bool == true) {
			if(judge==1){
				//转到登录页面			
				String returnUrl = this.getRequest().getContextPath() + "/index.jsp";
				this.getRequest().setCharacterEncoding("UTF-8");
				this.getResponse().setContentType("text/html; charset=UTF-8"); // 转码
				this.getResponse()
					.getWriter()
						.println(
							"<script language=\"javascript\">alert(\"密码修改成功，请重新登录!\");"
								+ "if(window.opener==null){window.top.location.href=\""
									+ returnUrl+ "\";}else{window.opener.top.location.href=\""
										+ returnUrl
											+ "\";window.close();}</script>");
				return null;				
			}
			else{
				this.getRequest().setAttribute("updateMsg", "手机号修改成功！");
				return "updatePartyMemberInfo";
			}
			 
		} else {
			this.getRequest().setAttribute("updateMsg", "修改失败！");
			return "updatePartyMemberInfo";
		}				
	}

	// 红色视频
	public String viewVideos()  {
		String search=this.getRequest().getParameter("search");
		//获得轮播图片
		List<IndexImage> indexImages=indexImageService.getByNew(4);
		this.getRequest().setAttribute("indexImages",indexImages);
		try {
			if (search!=null&&search.equals(new String(search.getBytes("iso8859-1"), "iso8859-1"))) {
				//判断是不是utf-8如果不是进行转码
				try {
					search= new String(search.getBytes("iso8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		PageCut<RedVideo> pc=redVideoService.getPC(16, page, search);
		this.getRequest().setAttribute("pc", pc);
		this.getRequest().setAttribute("search", search);		
		if(pc.getData().size()==0){
			this.getRequest().setAttribute("NoVideo", "搜索的内容不存在！");			
		}
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
		// 播放视频
		RedVideo redVideo = redVideoService.get(videoId);
		if(redVideo.getVideoUrl().startsWith("upload/video/")){
			// 获得视频观看记录
			WatchVideoRecord watchVideoRecord = watchVideoRecordService.getWVR(videoId, userId, 0);
			if (watchVideoRecord != null)
				this.getRequest().setAttribute("currentTime", watchVideoRecord.getCurrentTime());
			// 视频浏览次数加一
			redVideoService.updatewatchNumById(videoId);

			

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
						if(rvNext.size()>0){
							RedVideo rv1=rvNext.get(0);
							this.getRequest().setAttribute("next",rv1 );							
						}
					}
					
					if(fristVideo.getRv_Id()==videoId){
						this.getRequest().setAttribute("prev", fristVideo);
						this.getRequest().setAttribute("notice", "前面没有了");
					}else{
						List<RedVideo> rpPrev=redVideoService.getPrevRecordById(videoId);
						if(rpPrev.size()>0){
							RedVideo rv2=rpPrev.get(0);
							this.getRequest().setAttribute("prev", rv2);							
						}
					}
					return "viewing";

		}else{
			String  strVar="";
			strVar += "<script language=\"javascript\">";
			strVar += "window.top.location.href=\""+redVideo.getVideoUrl()+"\";";
			strVar += "</script>";


			this.getRequest().setCharacterEncoding("UTF-8");
			this.getResponse().setContentType("text/html; charset=UTF-8"); // 转码
			this.getResponse()
					.getWriter()
					.println(strVar);
			return null;
		}
		
		
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
	/*public String findByName() throws Exception {
		String name = this.getRequest().getParameter("videoName"); // 视频名字
		PageCut<RedVideo> pc = redVideoService.getPC(12, page);
		System.out.println("模糊查询视频");
		this.getRequest().setAttribute("pc", pc);
		List<RedVideo> videosList = redVideoService.findByName(name);
		this.getRequest().setAttribute("videosList", videosList);
		return "viewVideos";
	}*/

	// 链接到红色文章
	public String getResPaper() throws Exception {
		/*List<RedPaper> paperList = redPaperService.findPaperByType();*/
		//获得轮播图片
		List<IndexImage> indexImages=indexImageService.getByNew(4);
		this.getRequest().setAttribute("indexImages",indexImages);
		
		//党建巡礼
		List<RedPaper> partyBuilding=redPaperService.getPaperByTpId(1, 5);
		partyBuilding=PaperUtil.titleLength(partyBuilding, 16);		
		this.getRequest().setAttribute("partyBuilding", partyBuilding);
		//高校咨讯
		List<RedPaper> universityCounseling=redPaperService.getPaperByTpId(2, 5);
		universityCounseling=PaperUtil.titleLength(universityCounseling, 16);
		this.getRequest().setAttribute("universityCounseling", universityCounseling);
		//新乡风貌
		List<RedPaper> xinxiangStyle=redPaperService.getPaperByTpId(3, 5);
		xinxiangStyle=PaperUtil.titleLength(xinxiangStyle, 16);
		this.getRequest().setAttribute("xinxiangStyle", xinxiangStyle);
		//媒体头条
		List<RedPaper> mediaHeadlines=redPaperService.getPaperByTpId(4, 5);
		mediaHeadlines=PaperUtil.titleLength(mediaHeadlines, 16);
		this.getRequest().setAttribute("mediaHeadlines", mediaHeadlines);
		//环球动态
		List<RedPaper> globalDynamics=redPaperService.getPaperByTpId(5, 5);
		globalDynamics=PaperUtil.titleLength(globalDynamics, 16);
		this.getRequest().setAttribute("globalDynamics", globalDynamics);
		//神州大地
		List<RedPaper> divineLand=redPaperService.getPaperByTpId(6, 5);
		divineLand=PaperUtil.titleLength(divineLand, 16);
		this.getRequest().setAttribute("divineLand", divineLand);		
		return "getResPaper";
	}

	// 进入某个文章版块的列表 如党建巡礼的文章列表
	public String paperSection() {
		String search=this.getRequest().getParameter("search");
		int paperTypeId=Integer.parseInt(this.getRequest().getParameter("paperTypeId"));
		pageCut=redPaperService.getPCByNew(page, 15, paperTypeId , search);
		this.getRequest().setAttribute("pc", pageCut);
		if(pageCut.getData().size()!=0){
			this.getRequest().setAttribute("paper", pageCut.getData().get(0));	
		}
		
		return "paperSection";
	}
	
	//搜索文章列表
	public String paperList(){
		String search=this.getRequest().getParameter("search");
		try {
			if (search.equals(new String(search.getBytes("iso8859-1"), "iso8859-1"))) {
				//判断是不是utf-8如果不是进行转码
				try {
					search= new String(search.getBytes("iso8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		pageCut=redPaperService.getPCByNew(page, 15,search,1);//1代表权限
		this.getRequest().setAttribute("pc", pageCut);
		this.getRequest().setAttribute("search", search);		
		if(pageCut.getData().size()==0){
			this.getRequest().setAttribute("NoSearch", "搜索的内容不存在！");			
		}
		return "paperList";
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
			if (rpNext.size()>0) {
				RedPaper rp1 = rpNext.get(0);
				this.getRequest().setAttribute("next", rp1);
			}
		}

		if (fristPaper.getRp_Id() == id) {
			this.getRequest().setAttribute("prev", fristPaper);
			this.getRequest().setAttribute("notice", "前面没有了");
		} else {
			List<RedPaper> rpPrev = redPaperService.getPrevRecordById(id, rp.getPaperTypeId());
			if(rpPrev.size()>0){
				RedPaper rp2 = rpPrev.get(0);
				this.getRequest().setAttribute("prev", rp2);				
			}
		}

		return "lookPaper";
	}
	
	//阅读文章  根据阅读权限
		public String lookPaperByTag() throws Exception{
			String search=this.getRequest().getParameter("search");
			try {
				if (search!=null&&search.equals(new String(search.getBytes("iso8859-1"), "iso8859-1"))) {
					//判断是不是utf-8如果不是进行转码
					try {
						search= new String(search.getBytes("iso8859-1"),"utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			
			int id=Integer.parseInt(this.getRequest().getParameter("rp_Id"));
			System.out.println("文章id"+id);
			redPaperService.updatePaperReadNum(id);//文章阅读次数加一
			RedPaper rp=redPaperService.getById(id);
			this.getRequest().setAttribute("paper", rp);
			
			//查询第一篇 最后一篇 作为临界点
			RedPaper lastPaper=redPaperService.getLastRecordById(search).get(0);
			RedPaper fristPaper=redPaperService.getFristRecordById(search).get(0);
			
			//查询上一篇 下一篇
			if(lastPaper.getRp_Id()==id){
				this.getRequest().setAttribute("next", lastPaper);
				this.getRequest().setAttribute("notice", "后面没有了");			
			}else{
				List<RedPaper> rpNext=redPaperService.getNextRecordById(id,search);
				if(rpNext.size()>0){
					RedPaper rp1=rpNext.get(0);
					this.getRequest().setAttribute("next",rp1 );
				}
			}
			
			if(fristPaper.getRp_Id()==id){
				this.getRequest().setAttribute("prev", fristPaper);
				this.getRequest().setAttribute("notice", "前面没有了");
			}else{
				List<RedPaper> rpPrev=redPaperService.getPrevRecordById(id,search);
				if(rpPrev.size()>0){
					RedPaper rp2=rpPrev.get(0);
					this.getRequest().setAttribute("prev", rp2);					
				}
			}
			this.getRequest().setAttribute("search", search);
			return "lookPaperByTag";
	}
		
	// 在线考试
	public String startTest() throws Exception {
		StartTest startTest = (StartTest) this.getRequest().getSession().getServletContext().getAttribute("startTest");
		if (startTest != null) {
			if (SwitchTime.strToTime(startTest.getStartTime()).before(new Date()) && SwitchTime.strToTime(startTest.getEndTime()).after(new Date())) {				
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
			if(question!=null){
				if (!question.getAnswer().equals(e.getAnswer())) {
					question.setMyAnswer(e.getAnswer());
				}
				question.setMyScore(e.getSocre());
				questionsList.add(question);
			}			
		}
		ExamLog examLog = examLogService.getExamLogByTpId(userId, userSort, tp_Id, st_Id);
		if(examLog!=null && questionsList.size()>0){
			this.getRequest().setAttribute("examLog", examLog);
			this.getRequest().setAttribute("questionsList", questionsList);
		}
		else{
			this.getRequest().setAttribute("NotQusetionInfo", "试题信息可能已被删除，无法查询！");
		}
		return "getExamDetails";
	}
	
	
	/*
	 * 链接在线自测
	 * */
	public String onlineSelfTest() throws Exception{
		List<Question> questionList=questionService.getRandomQuestions(4);
		if(questionList.size()>0){
			int testScore=0;
			for(Question q :questionList){
				testScore=testScore+q.getQuestion_socre();
			}
			this.getSession().put("questionList", questionList);
			this.getSession().put("testNum", questionList.size());
			this.getSession().put("testScore", testScore);
		}
		else{
			this.getRequest().setAttribute("NoQuestion", "暂时题库没有题！");
		}
		return "onlineSelfTest";
	}
	//获得自测考试详情记录
	public String selfExamDetails() throws Exception{
		int testNum=(Integer)this.getSession().get("testNum");
		int totalScore=0;//考试成绩				
		@SuppressWarnings("unchecked")
		List<Question> questionList = (List<Question>) this.getSession().get("questionList");
		for (int i = 0; i < testNum; i++) {
			String str = (String) this.getRequest().getParameter("answer" + i);
			String userAnswer = ((Character) str.charAt(0)).toString();// 考生答案
			int qt_Id = Integer.valueOf(str.substring(1));// 试题id
			int score = 0;// 该题得分
			Question question = (Question) questionList.toArray()[i];// 该题信息
			if (userAnswer.equals(questionService.getAnswersByQtId(qt_Id).getAnswer())) {
				score = question.getQuestion_socre();
				totalScore += score;			
			}else{
				question.setMyScore(0);
				question.setMyAnswer(userAnswer);
			}
			
		}
		this.getRequest().setAttribute("questionList", questionList);
		this.getRequest().setAttribute("totalScore",totalScore);
		return "selfExamDetails";
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
	
	//搜索时事新闻与学习园地的数据的方法
		public String select() {
			String type=this.getRequest().getParameter("type");
			//String select=this.getRequest().getParameter("select");
			if(type.equals("news")){
				return paperList();
			}
			if(type.equals("video")){
				return viewVideos();
			}
			return null;
	}
		
	
	/*
	 * //查询个人党费交纳
	 * 
	 * public String getPartyFree(){
	 * 
	 * return "getPartyFree"; }
	 */
		//跳转到党委简介页面
	public String partyIntroduction(){
		if(partyIntroductionService.findAll().size()>0){
			this.getRequest().setAttribute("partyIntroduction",partyIntroductionService.findAll().get(0));
		}else{
			this.getRequest().setAttribute("notice", "暂无内容");
		}
		return "partyIntroduction";
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
