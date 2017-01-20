package com.future.partymember.action.secretary;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.Inform;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.entity.Question;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.entity.StartTest;
import com.future.partymember.util.PageCut;
import com.future.partymember.util.SwitchTime;
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
	private Inform inform;
	

	public String login() throws Exception{
		//判断登录
		if((partySecretaryInfo=partySecretaryInfoService.
				findByAccountAndPassword(partySecretaryInfo))!=null){
			
			session.put("secretary",partySecretaryInfo);
			session.put("userSort", 1);//书记的身份
			session.put("partyBranch", partySecretaryInfo.getPartyBranch());
			session.put("userId", partySecretaryInfo.getPst_Id());//保存书记的id
			return "login";
		}else{
			return "error";
		}
	}
	
	
	// 在线考试
	public String startTest() throws Exception {
		StartTest startTest = (StartTest) this.getRequest().getSession().getServletContext().getAttribute("startTest");
		if (startTest != null) {
			if (SwitchTime.strToTime(startTest.getEndTime()).after(new Date())) {
				List<Question> questionsList = questionService.getQuestionsByTpId(startTest.getTestPaper().getTp_Id());

				// 计算考试时长和总分
				int totalScore = 0;
				for (Question q : questionsList) {
					totalScore += q.getQuestion_socre();
				}
				startTest.setTotalScore(totalScore);
				startTest.setTestNum(questionsList.size());
				this.getSession().put("questionsList", questionsList);
			} else {
				this.getRequest().setAttribute("NoTest", "暂时没有考试！");
			}
		} else {
			this.getRequest().setAttribute("NoTest", "暂时没有考试！");
		}
		return "startTest";
	}
	
	
	//转发到修改通知页面
	public String fUpdateInform(){
		Inform i=informService.getById(inform.getInfo_Id());
		this.getRequest().setAttribute("inform", i);
		return "fUpdateInform";
	}
	
	//转发到发布通知页面
	public String fAddInform(){	
		return "addInform";
	}
	
	//转发到管理通知页面
	public String fManageInfom(){
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		PageCut<Inform> pc=informService.getQuery(1, 5,psi.getPst_Id());
		this.getRequest().setAttribute("pc", pc);
		return "manageInfom";
	}
	
	//转发修改个人信息
	public String fUpdataPerson() throws Exception{
		return "fUpdataPerson";
		
	}
	
/*	//转发到在线视频列表页
	public String videoList() throws Exception{
		List<RedVideo> videosList=new ArrayList<RedVideo>();
		videosList=redVideoService.getAll();
		this.getRequest().setAttribute("videosList", videosList);
		return "videoList";
	}
	*/
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
	
	public Inform getInform() {
		return inform;
	}
	public void setInform(Inform inform) {
		this.inform = inform;
	}

}
