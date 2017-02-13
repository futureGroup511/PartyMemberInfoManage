package com.future.partymember.action;

import java.util.List;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.entity.Question;

public class PhoneAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//手机页面   分发控制 
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
			}
		}

		return "";
	}
	
	
	
	
	
	//手机在线测试
	public String phoneTest() throws Exception{
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
		//
		/*public String getInfo() throws Exception{
			
			return "getInfo";
		}*/

}
