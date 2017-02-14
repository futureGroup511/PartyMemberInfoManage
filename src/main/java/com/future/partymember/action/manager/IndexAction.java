package com.future.partymember.action.manager;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.ManagerInfo;

/*
*@auther:宋民举
*@mail:860080937@qq.com
*@Date:2016年12月2日,下午6:29:10
*@Descritpion:
*/
public class IndexAction extends BaseAction{
	private String account;
	private String password;
	private String randStr;
	public String execute(){
		return SUCCESS;
	}
	public String login(){
		return "login";
	}
	public String loginDo() throws IOException{
		String vCode=(String)this.getRequest().getSession().getAttribute("randStr");
		this.getRequest().getSession().removeAttribute("randStr");
		if(randStr==null || !randStr.equals(vCode) ){
			this.getRequest().setAttribute("remind", "验证码错误，请重试");
			return "login";
		}
		ManagerInfo managerInfo=managerInfoService.getByAccount(account);
		if (managerInfo!=null && managerInfo.getPassword().equals(password.toLowerCase())) {
			this.getRequest().getSession().setAttribute("user",managerInfo);
			this.getResponse().sendRedirect("index");
			return null;
		}else{
			this.getRequest().setAttribute("remind","登录失败，请检查账号和密码");
			return "login";
		}
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRandStr() {
		return randStr;
	}
	public void setRandStr(String randStr) {
		this.randStr = randStr;
	}
	
	public static String byteArrayToHex(byte[] byteArray) {  

		   // 首先初始化一个字符数组，用来存放每个16进制字符  

		   char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };  

		   // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））  

		   char[] resultCharArray =new char[byteArray.length * 2];  

		   // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去  

		   int index = 0;  

		   for (byte b : byteArray) {  

		      resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];  

		      resultCharArray[index++] = hexDigits[b& 0xf];  

		   }
		   return new String(resultCharArray);  
	}
	
}