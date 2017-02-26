package com.future.partymember.base;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.future.partymember.service.IDuePaymentRecordsService;
import com.future.partymember.service.IEPRModelService;
import com.future.partymember.service.IExamLogService;
import com.future.partymember.service.IExamPerRecordService;
import com.future.partymember.service.IIndexImgService;
import com.future.partymember.service.IInformService;
import com.future.partymember.service.ILeagueMemberService;
import com.future.partymember.service.IManagerInfoService;
import com.future.partymember.service.IPartyIntroductionService;
import com.future.partymember.service.IPartyMemberInfoService;
import com.future.partymember.service.IPartySecretaryInfoService;
import com.future.partymember.service.IQuestionService;
import com.future.partymember.service.IRedPaperService;
import com.future.partymember.service.IRedPaperTypeService;
import com.future.partymember.service.IRedVideoService;
import com.future.partymember.service.IRelationTransformService;
import com.future.partymember.service.IStartTestService;
import com.future.partymember.service.ITestPaperService;
import com.future.partymember.service.IWatchVideoRecordService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Action的公共类
 * @author 丁赵雷
 *
 */
public class BaseAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Map<String,Object> session;
	
	//service 注入
	@Resource
	protected IPartyIntroductionService partyIntroductionService;
	@Resource
	protected IDuePaymentRecordsService duePaymentRecordsService;
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
	protected IRedPaperTypeService redPaperTypeService;
	@Resource
	protected IWatchVideoRecordService watchVideoRecordService;
	@Resource
	protected ITestPaperService testPaperService;
	@Resource
	protected IExamPerRecordService examPerRecordService;
	@Resource
	protected IStartTestService startTestService;
	
	@Resource
	protected IEPRModelService ePRModelService;
	
	@Resource
	protected IIndexImgService indexImageService;
	
	protected HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	protected HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	protected ServletContext getContext(){
		return ServletActionContext.getServletContext();
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	
}
