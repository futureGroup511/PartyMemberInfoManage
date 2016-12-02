package com.future.partymember.base;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.future.partymember.service.IDuePaymentRecoedsService;
import com.future.partymember.service.IExamLogService;
import com.future.partymember.service.IInformService;
import com.future.partymember.service.ILeagueMemberService;
import com.future.partymember.service.IManagerInfoService;
import com.future.partymember.service.IPartyMemberInfoService;
import com.future.partymember.service.IPartySecretaryInfoService;
import com.future.partymember.service.IQuestionService;
import com.future.partymember.service.IRedPaperService;
import com.future.partymember.service.IRedVideoService;
import com.future.partymember.service.IRelationTransformService;
import com.future.partymember.service.IWatchVideoRecordService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Action的公共类
 * @author 丁赵雷
 *
 */
public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	protected HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	protected ServletContext getContext(){
		return ServletActionContext.getServletContext();
	}
	
	//service 注入
	protected IDuePaymentRecoedsService duePaymentRecoedsService;
	
	protected IExamLogService examLogService;
	
	protected IInformService informService;
	
	protected ILeagueMemberService leagueMemberService;
	
	protected IManagerInfoService managerInfoService;
	
	protected IPartyMemberInfoService partyMemberInfoService;
	
	protected IPartySecretaryInfoService partySecretaryInfoService;
	
	protected IQuestionService questionService;
	
	protected IRedPaperService redPaperService;
	
	protected IRedVideoService redVideoService;
	
	protected IRelationTransformService relationTransformService;
	
	protected IWatchVideoRecordService watchVideoRecordService;
	
	

}
