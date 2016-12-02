package com.future.partymember.base;

import javax.annotation.Resource;
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
	@Resource
	protected IDuePaymentRecoedsService duePaymentRecoedsService;
	@Resource
	protected IExamLogService examLogService;
	@Resource
	protected IInformService informService;
	@Resource
	protected ILeagueMemberService leagueMemberService;
	@Resource
	protected IManagerInfoService managerInfoService;
	@Resource
	protected IPartyMemberInfoService partyMemberInfoService;
	@Resource
	protected IPartySecretaryInfoService partySecretaryInfoService;
	@Resource
	protected IQuestionService questionService;
	@Resource
	protected IRedPaperService redPaperService;
	@Resource
	protected IRedVideoService redVideoService;
	@Resource
	protected IRelationTransformService relationTransformService;
	@Resource
	protected IWatchVideoRecordService watchVideoRecordService;
	
	

}
