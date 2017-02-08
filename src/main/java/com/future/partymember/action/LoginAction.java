package com.future.partymember.action;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;
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
			this.getRequest().setAttribute("codeMeg", "验证码错误!");
			return "login";
		}
		
		if(userInfo.getAccount().length()>=8){
			PartyMemberInfo partyMemberInfo=partyMemberInfoService.login(userInfo.getAccount(), 
					userInfo.getPassword());
			System.out.println(userInfo.getPassword());
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
				
			}
			return "partySecretary";
		}else {
			this.getRequest().setAttribute("loginMeg", "用户名或密码错误！");
			return LOGIN;
		}
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
