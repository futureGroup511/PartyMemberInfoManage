package com.future.partymember.action;


import java.io.IOException;
import java.util.List;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.entity.Question;
import com.future.partymember.entity.UserInfo;

public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfo userInfo;
	private String randStr;
	
	
	@Override
	public String execute() throws Exception {
		/**
		 * 这是用来校验验证码的
		 */
		String vCode=(String)this.getRequest().getSession().getAttribute("randStr");
		this.getRequest().getSession().removeAttribute("randStr");
		if(randStr==null || !randStr.equals(vCode) ){
			this.getRequest().setAttribute("codeMeg", "验证码错误");
			return "login";
		}
		/*System.out.println(userInfo.getPassword());*/
		if(userInfo.getAccount().length()>=8){
			PartyMemberInfo partyMemberInfo=partyMemberInfoService.login(userInfo.getAccount(), 
					userInfo.getPassword());
			if(partyMemberInfo!=null){
				this.getSession().put("userId", partyMemberInfo.getPtm_Id());
				this.getSession().put("userSort", 0);
				return "partyMember";
			}else{
				this.getRequest().setAttribute("loginMeg", "用户名或密码错误！");
				return LOGIN;
			}			
		}else if(userInfo.getAccount().length()>=6&&userInfo.getAccount().length()<8){
			
			PartySecretaryInfo  partySecretaryInfo=null;//书记实体类
			
			if((partySecretaryInfo=partySecretaryInfoService.findByAccountAndPassword(userInfo.getAccount(), 
					userInfo.getPassword()))!=null){	
				session.put("secretary",partySecretaryInfo);
				session.put("userSort", 1);//书记的身份
				session.put("partyBranch", partySecretaryInfo.getPartyBranch());
				session.put("userId", partySecretaryInfo.getPst_Id());//保存书记的id
				return "partySecretary";
			}else {
				this.getRequest().setAttribute("loginMeg", "用户名或密码错误！");
				return LOGIN;
			}
		}
		return LOGIN;
	}
	
	/**
	 * 注销
	 */
	public String logout(){
		if(session.get("userId")!=null && session.get("userSort")!=null ){
				session.remove("userId");
				session.remove("userSort");
		}
		if(session.get("secretary")!=null){
			session.remove("secretary");
		}
		return "logout";
	}
	


	
	/**
	 * 在进入登录页面之前调用此方法
	 * @throws IOException 
	 */
	public String preLogin() throws IOException{
		/**
		 * 专门用来接受手机客户端传来的参数,判断到底跳转到那个页面
		 * 1 个人信息
		 * 2考试
		 * 3视频
		 */
		String phone=this.getRequest().getParameter("phone");
		if(phone!=null&&!phone.equals("")){
			session.put("phoneJump",phone);//将参数保存到session中 
			System.out.println("手机"+phone);
			return "phoneLogin";
		}else{
			this.getRequest().setCharacterEncoding("UTF-8");
			this.getResponse().setContentType("text/html; charset=UTF-8"); // 转码
			this.getResponse()
					.getWriter()
					.println(
							"<script language=\"javascript\">alert(\"您登录的地址不正确!\");</script>");
			
		}

		return null;
	}
	
	
	
	
	/**
	 * 手机登录入口
	 * @return
	 * @throws Exception
	 */
	public String phoneLogin() throws Exception {
		

		/**
		 * 这是用来校验验证码的
		 */
		String vCode=(String)this.getRequest().getSession().getAttribute("randStr");
		this.getRequest().getSession().removeAttribute("randStr");
		if(randStr==null || !randStr.equals(vCode) ){
			this.getRequest().setAttribute("notice", "验证码错误!");
			return "phoneLogin";
		}
		/*System.out.println(userInfo.getPassword());*/
		if(userInfo.getAccount().length()>=8){
			PartyMemberInfo partyMemberInfo=partyMemberInfoService.login(userInfo.getAccount(), 
					userInfo.getPassword());
			if(partyMemberInfo!=null){
				this.getSession().put("userId", partyMemberInfo.getPtm_Id());
				this.getSession().put("userSort", 0);
				session.put("partyMember", partyMemberInfo);
				return "user";
			}else{
				this.getRequest().setAttribute("notice", "用户名或密码错误！");
				return "phoneLogin";
			}			
		}else if(userInfo.getAccount().length()>=6&&userInfo.getAccount().length()<8){
			
			PartySecretaryInfo  partySecretaryInfo=null;//书记实体类
			if((partySecretaryInfo=partySecretaryInfoService.findByAccountAndPassword(userInfo.getAccount(), 
					userInfo.getPassword()))!=null){
				System.out.println("书记有");
				session.put("secretary",partySecretaryInfo);
				session.put("userSort", 1);//书记的身份
				session.put("partyBranch", partySecretaryInfo.getPartyBranch());
				session.put("userId", partySecretaryInfo.getPst_Id());//保存书记的id
				return "user";
			}else {
				this.getRequest().setAttribute("notice", "用户名或密码错误！");
				return "phoneLogin";
			}
		}
		return "phoneLogin";
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

	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getRandStr() {
		return randStr;
	}

	public void setRandStr(String randStr) {
		this.randStr = randStr;
	}


}
