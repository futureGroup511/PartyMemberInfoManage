package com.future.partymember.action.secretary;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.entity.RedVideo;
/**
 * 书记的转发类
 * @author 丁赵雷
 *
 */
@Controller(value="pSForwardAction")
@Scope("prototype")
public class PSForwardAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PartySecretaryInfo  partySecretaryInfo;//书记实体类
	
	
	public String login() throws Exception{
		//判断登录
		if((partySecretaryInfo=partySecretaryInfoService.
				findByAccountAndPassword(partySecretaryInfo))!=null){
			
			session.put("secretary",partySecretaryInfo);
			return "login";
		}else{
			return "error";
		}
	}
	
	
	//转发修改个人信息
	public String fUpdataPerson() throws Exception{
		return "fUpdataPerson";
		
	}
	
	//转发到在线视频列表页
	public String videoList() throws Exception{
		List<RedVideo> videosList=new ArrayList<RedVideo>();
		videosList=redVideoService.getAll();
		this.getRequest().setAttribute("videosList", videosList);
		return "videoList";
	}
	
	//转发到在线文章列表页
	public String paperList() throws Exception{
		List<RedPaper> paperList=redPaperService.findPaperByType();
		this.getRequest().setAttribute("paperList", paperList);
		return "paperList";
	}

	
	
	/***************get******set******************************************************************/
	public PartySecretaryInfo getPartySecretaryInfo() {
		return partySecretaryInfo;
	}
	public void setPartySecretaryInfo(PartySecretaryInfo partySecretaryInfo) {
		this.partySecretaryInfo = partySecretaryInfo;
	}

}
