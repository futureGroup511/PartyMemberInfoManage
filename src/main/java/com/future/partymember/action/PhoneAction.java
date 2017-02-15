package com.future.partymember.action;

import java.util.List;


import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.entity.Question;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.entity.UserInfo;
import com.future.partymember.entity.WatchVideoRecord;
import com.future.partymember.util.SwitchTime;

public class PhoneAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//手机页面   分发控制 phoneController
	public String phoneController() throws Exception{
		/**
		 * 1 个人信息
		 * 2 考试
		 * 3 视频
		 */
		
		if(session.get("phoneJump")!=null&&session.get("phoneJump")!=""){
			int phoneFlag=Integer.parseInt((String) session.get("phoneJump"));
			System.out.println("phoneFlag "+phoneFlag);
			
			
			if(phoneFlag==1){
				int userSort=(Integer)session.get("userSort");
				if(userSort==0){
					PartyMemberInfo pm=(PartyMemberInfo) session.get("partyMember");
					this.getRequest().setAttribute("userInfo", pm);
				}else if(userSort==1){
					PartySecretaryInfo ps=(PartySecretaryInfo)session.get("secretary");
					session.put("userInfo",ps);
				}
				return "getInfo";
			}else if(phoneFlag==2){
				System.out.println("这是手机在线测评");
				return phoneTest();
			}else if(phoneFlag==3){
				System.out.println("手机视频列表");
				return phoneVideoList();
			}
		}

		return "";
	}
	
	
	
	
	
	//手机在线测试
	public String phoneTest() throws Exception{
			List<Question> questionList=questionService.getRandomQuestions(10);
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
			return "phoneTest";
		}
		
		//手机在线测试结果
		public String phoneExamDetails() throws Exception{
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
			return "phoneExamDetails";
		}

		
		
		//手机在线视频列表页
		public String phoneVideoList(){
		 	List<RedVideo> phoneHotVideoList=redVideoService.getHot(4);
		 	List<RedVideo> phoneNewVideoList=redVideoService.getNew(10);
		 	
		 	
		 	
		 	this.getRequest().setAttribute("phoneHotFristVideo", phoneHotVideoList.get(0));
		 	this.getRequest().setAttribute("phoneHotLastVideo", phoneHotVideoList.get(3));
		 	this.getRequest().setAttribute("phoneHotVideoList", phoneHotVideoList);
		 	this.getRequest().setAttribute("phoneNewVideoList", phoneNewVideoList);
			
			return "phoneVideoList";
		}
		
		
		//手机看视频
		public String lookVideo() throws Exception{
			//先判断身份在跳转
			
			int userSort=(Integer) session.get("userSort");
			
			int id=Integer.parseInt(this.getRequest().getParameter("rv_Id"));//视频id
			
			int userId=5;
			
			//书记
			if(userSort==1){
				
				PartySecretaryInfo user =(PartySecretaryInfo)session.get("secretary");
				userId=user.getPst_Id();//书记的id
			}
			if(userSort==0){
				PartyMemberInfo user =(PartyMemberInfo)session.get("partyMember");
				userId=user.getPtm_Id();//党员的id
			}
			
			RedVideo v =redVideoService.get(id);
			if(v.getVideoUrl().startsWith("upload/video/")){
				//获得视频观看记录
				WatchVideoRecord watchVideoRecord=watchVideoRecordService.getWVR(id, userId,userSort);
				if(watchVideoRecord!=null)//设置上次观看该视频的时间
					this.getRequest().setAttribute("currentTime", watchVideoRecord.getCurrentTime());
				
				redVideoService.updatewatchNumById(id);//视频观看次数加一
				
				this.getRequest().setAttribute("video", v);
				
				
				return "phoneLookVideo";
			}
			else{
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
			
			
			//先判断身份
			int  userSort=(Integer)session.get("userSort");
			int userId=0;

			long time = Integer.parseInt(getRequest().getParameter("time"));//观看视频的时间			
			
			
			//书记
			if(userSort==1){
				
				PartySecretaryInfo user =(PartySecretaryInfo)session.get("secretary");
				userId=user.getPst_Id();
				
				time = time + user.getLearnTime();
				String strTime = SwitchTime.switchTime(time);				
				user.setLearnTime(time);
				user.setStrLearnTime(strTime);
				partySecretaryInfoService.updatePersonInfo(user);//更新个人学习时间
			}
			if(userSort==0){
				PartyMemberInfo user =(PartyMemberInfo) session.get("partyMember");
				userId=user.getPtm_Id();
				
				time = time + user.getLearnTime();
				String strTime = SwitchTime.switchTime(time);
				user.setLearnTime(time);
				user.setStrLearnTime(strTime);
				partyMemberInfoService.updatePartyMemberInfo(user);//更新个人学习时间
			}
			
			
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
			watchVideoRecord=watchVideoRecordService.getWVR(videoId, userId,userSort);

			if (watchVideoRecord == null) {
				watchVideoRecord = new WatchVideoRecord();
				watchVideoRecord.setRv_id(videoId);
				watchVideoRecord.setPm_id(userId);
				watchVideoRecord.setCurrentTime(currentTime);
				watchVideoRecord.setPartySort(1);
				watchVideoRecordService.addWVR(watchVideoRecord);//添加一条视频播放记录
				
			} else {
				watchVideoRecord.setRv_id(videoId);
				watchVideoRecord.setPm_id(userId);
				watchVideoRecord.setCurrentTime(currentTime);
				watchVideoRecordService.updateWVR(watchVideoRecord);//更新视频播放记录

			}
		}
		

}
