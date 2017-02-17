package com.future.partymember.action.secretary;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.ExamLog;
import com.future.partymember.entity.ExamPerRecord;
import com.future.partymember.entity.Inform;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.entity.Question;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.entity.StartTest;
import com.future.partymember.entity.WatchVideoRecord;
import com.future.partymember.service.IPartyMemberInfoService;
import com.future.partymember.service.IRedPaperService;
import com.future.partymember.service.IRedVideoService;
import com.future.partymember.util.PageCut;
import com.future.partymember.util.PaperUtil;
import com.future.partymember.util.SwitchTime;

@Controller(value="partySecretaryAction")
@Scope(value="prototype")
public class PartySecretaryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PartySecretaryInfo partySecretaryInfo;
	private PageCut<?> pageCut; 
	private Inform inform;//用来封装通知消息的
	private int page=1;






	/**
	 * 查看个人信息
	 * @return
	 * @throws Exception
	 */
	public String lookMyself() throws Exception{

		return "lookMyself";
	}
	
	
	
	//查看党员的详细信息
	public String partyMemberData(){
		if(this.getRequest().getParameter("pmiId")!=null){
			int id=Integer.parseInt(this.getRequest().getParameter("pmiId"));
			PartyMemberInfo pmi=partyMemberInfoService.getPartyMemberInfoById(id);
			
			if(pmi!=null){
				this.getRequest().setAttribute("pmi", pmi);
			}else{
				this.getRequest().setAttribute("notice", "没有此人详细信息");
			}
		}else{
			this.getRequest().setAttribute("notice", "没有此人详细信息");
		}
		return "partyMemberData";
	}
	
	
	
	/**
	 * 登录
	 * @return
	 */
	
	public String login(){
		
		 
		List<RedPaper> hotPaperList=redPaperService.getHot(5);
	 	List<RedPaper> newPaperList=redPaperService.getNew(5);
	 	
	 	
	 	List<RedVideo> hotVideoList=redVideoService.getHot(9);
	 	List<RedVideo> newVideoList=redVideoService.getNew(9);
	 	List<Inform> newInformList= informService.getNew(2);
	 	
	 	
	 	this.getRequest().setAttribute("hotPaper", PaperUtil.titleLength(hotPaperList, 17));
	 	this.getRequest().setAttribute("newPaper", PaperUtil.titleLength(newPaperList,17));
	 	this.getRequest().setAttribute("hotVideo", hotVideoList);
	 	this.getRequest().setAttribute("newVideo", newVideoList);
	 	this.getRequest().setAttribute("newInform", newInformList);
	 	
		return "login";
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
			this.getRequest().setAttribute("myExamLogMsg", "暂时没有考试记录！");
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

	
	
	// 考试提交
	public String getExamRecord() throws Exception {
		// 考试记录详情集合
		List<ExamPerRecord> examPerRecordList = new ArrayList<ExamPerRecord>();
		// 考试的试卷信息
		StartTest startTest = (StartTest) this.getRequest().getSession().getServletContext().getAttribute("startTest");
		int tp_Id = startTest.getTestPaper().getTp_Id();// 试卷id
		int st_Id=startTest.getSt_Id();//开启试卷记录id
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
		String partySecretaryName = partySecretaryInfoService.findById(userId).getUsername();
		String partyBranch=partySecretaryInfoService.findById(userId).getPartyBranch();
		String date = SwitchTime.dateToTimeStr(new Date());
		ExamLog examLog = new ExamLog(st_Id,tp_Id, paperName, userId, partySecretaryName, partyBranch,userSort, totalScore, date, testTime,
				testTotalScore, testNum);

		int datebool = examLogService.grtElIdByDate(st_Id);
		if (datebool==0) {
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
		return "getExamRecord";
	}
	/* 在线测试-焦祥宇加*/
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
	//查看通知
	public String lookInform(){
		if(inform.getInfo_Id()!=0){
			Inform i=informService.getById(inform.getInfo_Id());
			this.getRequest().setAttribute("inform", i);
		}
		
		return "lookInform";
	}
	
	
	//通知列表
	public String informList(){
		
		System.out.println("通知列表的分页"+page);
		PageCut<Inform> pc=informService.getInformList(page, 5,1,3);//1 3 通知的权限
		this.getRequest().setAttribute("pc", pc);
		return "informList";
	}
	
	//修改通知
	public String updateInform(){
		Inform i=informService.getById(inform.getInfo_Id());
		System.out.println("修改通知的id"+inform.getInfo_Id());
		if(inform.getTitle().equals("")||inform.getContent().equals("")){
			this.getRequest().setAttribute("notice", "内容不能为空");
		}else{
			System.out.println("修改通知的内容"+inform.getContent());
			System.out.println("修改通知的标题"+inform.getTitle());
			i.setContent(inform.getContent());
			i.setTitle(inform.getTitle());
			System.out.println(i);
			informService.updateInform(i);//更新通知
			this.getRequest().setAttribute("notice", "修改成功");
		}
		return "updateInform";
	}
	
	
	//删除通知
	public String deleteInform(){
		if(inform.getInfo_Id()!=0){
			informService.deleteInform(inform.getInfo_Id());//删除记录
			this.getRequest().setAttribute("notice", "编号为"+inform.getInfo_Id()+"的通知删除成功");
		}else{
			this.getRequest().setAttribute("notice", "您的操作不合法");
		}

		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		System.out.println("通知的分页"+page);
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		PageCut<Inform> pc=informService.getQuery(page, 5, psi.getPst_Id());
		this.getRequest().setAttribute("pc", pc);
		return "manageInfom";
	}
	
	
	//通知的分页
	public String paperInform(){
		System.out.println("通知的分页"+page);
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		PageCut<Inform> pc=informService.getQuery(page, 5, psi.getPst_Id());
		this.getRequest().setAttribute("pc", pc);
		return "manageInfom";
	}
	
	//发布通知
	public String addInform(){
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		
		if(inform.getTitle().equals("")||inform.getContent().equals("")){
			this.getRequest().setAttribute("notice", "内容不能为空");
		}else{
			inform.setAddresser(psi.getUsername());
			inform.setSenderType(1);		
			inform.setSendDate(new Date());
			inform.setSenderId(psi.getPst_Id());
			inform.setInfo_tag(7);
			inform.setPartBranch(psi.getPartyBranch());
			informService.addInform(inform);//插入一条记录
			this.getRequest().setAttribute("notice", "发布成功");
		}
		return "addInform";
	}
	
	
	//查看所管理的党员信息
	public String lookOfPartyMember() throws Exception{
		//先得到书记对象
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
		System.out.println("search"+search);
		System.out.println("page"+page);
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		System.out.println("书记所属党支部"+psi.getPartyBranch());
		PageCut<PartyMemberInfo>  pCut=partyMemberInfoService.getPageCut(page, 5, search, psi.getPartyBranch());
		
		
		if( search==null || search.length()==0){
			
		}else{
			for(PartyMemberInfo p:pCut.getData()){
				String format="<span class=\"search\">%s</span>";
				p.setNation(p.getNation().replaceAll(search, String.format(format, search)));
				p.setUsername(p.getUsername().replaceAll(search, String.format(format, search)));
				p.setNativePlace(p.getNativePlace().replaceAll(search, String.format(format, search)));
				p.setPhoneNo(p.getPhoneNo().replaceAll(search, String.format(format, search)));
			}
		}
		
		this.getRequest().setAttribute("pc", pCut);
		this.getRequest().setAttribute("search", search);
		return "lookOfPartyMember";
	}
	
	
	//修改个人手机号
	public String updatePhone() throws Exception{
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		String phone = this.getRequest().getParameter("phone");//得到新的手机号
		psi.setPhoneNo(phone);
		partySecretaryInfoService.updatePersonInfo(psi);
		this.getRequest().setAttribute("notice", "修改成功");
		return "updatePhone";
	}
	
	
	//修改个人密码
	public String updatePassword() throws Exception{
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		System.out.println("psi"+psi);

		String password2=(String)this.getRequest().getParameter("password2");//确认密码
		System.out.println("新密码"+password2);
		
		//判断密码必须是字母和数字的组合长度为8到16位
		
			psi.setPassword(password2);
			partySecretaryInfoService.updatePersonInfo(psi);//更新个人信息
			this.getRequest().setAttribute("notice", "修改成功");
			
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
	
	
	//视频列表和分页
	public String videoList(){
		System.out.println("分页"+page);
		String search=this.getRequest().getParameter("search");
		System.out.println("search  "+search);
		PageCut<RedVideo> pc=redVideoService.getPC(16, page, search);
		this.getRequest().setAttribute("pc", pc);
		
		
		return "videoList";
	}
	
	
	//观看视频
	public String lookVideo() throws Exception{
		int id=Integer.parseInt(this.getRequest().getParameter("rv_Id"));//视频id
		
		partySecretaryInfo =(PartySecretaryInfo)session.get("secretary");
		int psiId=partySecretaryInfo.getPst_Id();//书记的id
		RedVideo v =redVideoService.get(id);
		if(v.getVideoUrl().startsWith("upload/video/")){
			//获得视频观看记录
			WatchVideoRecord watchVideoRecord=watchVideoRecordService.getWVR(id, psiId,1);
			if(watchVideoRecord!=null)//设置上次观看该视频的时间
				this.getRequest().setAttribute("currentTime", watchVideoRecord.getCurrentTime());
			
			redVideoService.updatewatchNumById(id);//视频观看次数加一
			
			this.getRequest().setAttribute("video", v);
			
			//查询第一个和最后一个视频作为临界点
			RedVideo lastVideo=redVideoService.getLastRecordById().get(0);
			RedVideo fristVideo=redVideoService.getFristRecordById().get(0);
			
			//查询上一个 下一个
			if(lastVideo.getRv_Id()==id){
				this.getRequest().setAttribute("next", lastVideo);
				this.getRequest().setAttribute("notice", "后面没有了");			
			}else{
				List<RedVideo> rvNext=redVideoService.getNextRecordById(id);
				
				if(rvNext.size()>0){
					RedVideo rv1=rvNext.get(0);
					this.getRequest().setAttribute("next",rv1 );
				}
			}
			
			if(fristVideo.getRv_Id()==id){
				this.getRequest().setAttribute("prev", fristVideo);
				this.getRequest().setAttribute("notice", "前面没有了");
			}else{
				List<RedVideo> rpPrev=redVideoService.getPrevRecordById(id);
				if(rpPrev.size()>0){
		
					RedVideo rv2=rpPrev.get(0);
					this.getRequest().setAttribute("prev", rv2);
				}
			}

			return "lookVideo";
		}else{
			String  strVar="";
			strVar += "<script language=\"javascript\">";
			strVar += "window.top.location.href=\""+v.getVideoUrl()+"\";";
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
	 * 更新书记的学习时间和视频播放记录历史 丁赵雷 
	 */
	public void updateLearnTime() throws Exception {

		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		
		long time = Integer.parseInt(getRequest().getParameter("time"));//观看视频的时间
		System.out.println("time" + time);

		time = time + psi.getLearnTime();
		String strTime = SwitchTime.switchTime(time);
		System.out.println("书记的学习时长"+strTime);
		psi.setLearnTime(time);
		psi.setStrLearnTime(strTime);
		
		partySecretaryInfoService.updatePersonInfo(psi);//更新个人学习时间
		
		// 视频播放记录历史
		System.out.println("*******视频播放记录历史******");
		String vt = getRequest().getParameter("currentTime");
		long currentTime = 0;
		if (vt.indexOf(".") > 0) {
			currentTime = Integer.valueOf(vt.substring(0, vt.indexOf(".")));
		} else {
			currentTime = Integer.valueOf(vt);
		}

		System.out.println("currentTime" + currentTime);

		int videoId = Integer.valueOf(getRequest().getParameter("videoId"));
		WatchVideoRecord watchVideoRecord;
		watchVideoRecord=watchVideoRecordService.getWVR(videoId, psi.getPst_Id(),1);

		System.out.println(watchVideoRecord);
		if (watchVideoRecord == null) {
			watchVideoRecord = new WatchVideoRecord();
			watchVideoRecord.setRv_id(videoId);
			watchVideoRecord.setPm_id(psi.getPst_Id());
			watchVideoRecord.setCurrentTime(currentTime);
			watchVideoRecord.setPartySort(1);
			watchVideoRecordService.addWVR(watchVideoRecord);//添加一条视频播放记录
			
		} else {
			watchVideoRecord.setRv_id(videoId);
			watchVideoRecord.setPm_id(psi.getPst_Id());
			watchVideoRecord.setCurrentTime(currentTime);
			watchVideoRecordService.updateWVR(watchVideoRecord);//更新视频播放记录

		}
	}
	
	
	//进入某个文章版块
	public String paperSection(){
		String search=this.getRequest().getParameter("search");
		int paperTypeId=Integer.parseInt(this.getRequest().getParameter("paperTypeId"));
		pageCut=redPaperService.getPCByNew(page, 15, paperTypeId , search);
		this.getRequest().setAttribute("pc", pageCut);
		if(pageCut.getData().size()!=0){
			this.getRequest().setAttribute("paper", pageCut.getData().get(0));
			System.out.println("文章板块"+pageCut.getData().get(0));
		}
		return "paperSection";
	}
	
	//文章列表
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

		return "paperList";
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
	
	
	//阅读文章
	public String lookPaper() throws Exception{
		int id=Integer.parseInt(this.getRequest().getParameter("rp_Id"));
		System.out.println("文章id"+id);
		redPaperService.updatePaperReadNum(id);//文章阅读次数加一
		RedPaper rp=redPaperService.getById(id);
		this.getRequest().setAttribute("paper", rp);
		
		//查询第一篇 最后一篇 作为临界点
		RedPaper lastPaper=redPaperService.getLastRecordById(rp.getPaperTypeId()).get(0);
		RedPaper fristPaper=redPaperService.getFristRecordById(rp.getPaperTypeId()).get(0);
		
		//查询上一篇 下一篇
		if(lastPaper.getRp_Id()==id){
			this.getRequest().setAttribute("next", lastPaper);
			this.getRequest().setAttribute("notice", "后面没有了");			
		}else{
			List<RedPaper> rpNext=redPaperService.getNextRecordById(id,rp.getPaperTypeId());
			if(rpNext.size()>0){
				RedPaper rp1=rpNext.get(0);
				this.getRequest().setAttribute("next",rp1 );
			}
		}
		
		if(fristPaper.getRp_Id()==id){
			this.getRequest().setAttribute("prev", fristPaper);
			this.getRequest().setAttribute("notice", "前面没有了");
		}else{
			List<RedPaper> rpPrev=redPaperService.getPrevRecordById(id, rp.getPaperTypeId());
			if(rpPrev.size()>0){
				RedPaper rp2=rpPrev.get(0);
				this.getRequest().setAttribute("prev", rp2);
			}

		}

		return "lookPaper";
	}
	
	//跳转到联系我们页面
	public String connectUs(){
		return "connectUs";
	}
	
	//搜索时事新闻与学习园地的数据的方法
	public String select(){
		String type=this.getRequest().getParameter("type");
		if(type.equals("news")){
			return paperList();
		}
		if(type.equals("video")){
			return videoList();
		}
		return null;
	}

	public PartySecretaryInfo getPartySecretaryInfo() {
		return partySecretaryInfo;
	}

	public void setPartySecretaryInfo(PartySecretaryInfo partySecretaryInfo) {
		this.partySecretaryInfo = partySecretaryInfo;
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
	
	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}



}
