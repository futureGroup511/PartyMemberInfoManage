package com.future.partymember.action.secretary;



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
import com.future.partymember.util.PaperUtil;
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
	
	
	//返回首页
	public String fIndex(){
		List<RedPaper> hotPaperList=redPaperService.getHot(5);
	 	List<RedPaper> newPaperList=redPaperService.getNew(5);
	 	List<RedVideo> hotVideoList=redVideoService.getHot(9);
	 	List<RedVideo> newVideoList=redVideoService.getNew(9);
	 	List<Inform> newInformList= informService.getNew(2);

	 	
	 	this.getRequest().setAttribute("hotPaper", PaperUtil.titleLength(hotPaperList, 17));
	 	this.getRequest().setAttribute("newPaper", PaperUtil.titleLength(newPaperList,17));
	 	this.getRequest().setAttribute("hotVideo", hotVideoList);
	 	this.getRequest().setAttribute("newVideo", newVideoList);
	 	this.getRequest().setAttribute("newInform", newInformList);
		return "index";
	}
	
	// 在线考试
	public String startTest() throws Exception {
		StartTest startTest = (StartTest) this.getRequest().getSession().getServletContext().getAttribute("startTest");
		if (startTest != null) {
			if (SwitchTime.strToTime(startTest.getStartTime()).before(new Date())&& SwitchTime.strToTime(startTest.getEndTime()).after(new Date())) {
				List<Question> questionsList = questionService.getQuestionsByTpId(startTest.getTestPaper().getTp_Id());

				// 计算考试时长和总分
				int totalScore = 0;
				for (Question q : questionsList) {
					totalScore += q.getQuestion_socre();
				}
				startTest.setTotalScore(totalScore);
				startTest.setTestNum(questionsList.size());
				this.getSession().put("questionsList", questionsList);
				long time=SwitchTime.strToTime(startTest.getEndTime()).getTime();				
				this.getSession().put("time", time);
			} else {
				this.getRequest().setAttribute("NoTest", "暂时没有考试！");
			}
		} else {
			this.getRequest().setAttribute("NoTest", "暂时没有考试！");
		}
		return "startTest";
	}
	
	/*
	 * <!-- 在线测试-焦祥宇加 -->
	 * 链接在线自测
	 * */
	public String onlineSelfTest() throws Exception{
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
		return "onlineSelfTest";
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
		//党建巡礼
				List<RedPaper> partyBuilding=redPaperService.getPaperByTpId(1, 5);
				partyBuilding=PaperUtil.titleLength(partyBuilding, 16);
				if(partyBuilding.size()>0){
					String modelName1=partyBuilding.get(0).getPaperType();
					this.getRequest().setAttribute("madelNameRight1", modelName1.substring(0, 1));
					this.getRequest().setAttribute("madelNameLeft1", modelName1.substring(2, 1));
				}
				this.getRequest().setAttribute("partyBuilding", partyBuilding);
				//高校咨讯
				List<RedPaper> universityCounseling=redPaperService.getPaperByTpId(2, 5);
				universityCounseling=PaperUtil.titleLength(universityCounseling, 16);
				
				if(universityCounseling.size()>0){
					String modelName2=universityCounseling.get(0).getPaperType();
					this.getRequest().setAttribute("madelNameRight2", modelName2.substring(0, 1));
					this.getRequest().setAttribute("madelNameLeft2", modelName2.substring(2, 1));
					
				}
				this.getRequest().setAttribute("universityCounseling", universityCounseling);
				//新乡风貌
				List<RedPaper> xinxiangStyle=redPaperService.getPaperByTpId(3, 5);
				xinxiangStyle=PaperUtil.titleLength(xinxiangStyle, 16);
				if(xinxiangStyle.size()>0){
					
					String modelName3=xinxiangStyle.get(0).getPaperType();
					this.getRequest().setAttribute("madelNameRight1", modelName3.substring(0, 1));
					this.getRequest().setAttribute("madelNameLeft1", modelName3.substring(2, 1));
				}
				this.getRequest().setAttribute("xinxiangStyle", xinxiangStyle);
				//媒体头条
				List<RedPaper> mediaHeadlines=redPaperService.getPaperByTpId(4, 5);
				mediaHeadlines=PaperUtil.titleLength(mediaHeadlines, 16);
				if(mediaHeadlines.size()>0){
					String modelName4=mediaHeadlines.get(0).getPaperType();
					this.getRequest().setAttribute("madelName4", modelName4);
				}
				this.getRequest().setAttribute("mediaHeadlines", mediaHeadlines);
				//环球动态
				List<RedPaper> globalDynamics=redPaperService.getPaperByTpId(5, 5);
				globalDynamics=PaperUtil.titleLength(globalDynamics, 16);
				if(globalDynamics.size()>0){
					String modelName5=globalDynamics.get(0).getPaperType();
					this.getRequest().setAttribute("madelName5", modelName5);
				}
				this.getRequest().setAttribute("globalDynamics", globalDynamics);
				//神州大地
				List<RedPaper> divineLand=redPaperService.getPaperByTpId(6, 5);
				divineLand=PaperUtil.titleLength(divineLand, 16);
				if(divineLand.size()>0){
					String modelName6=divineLand.get(0).getPaperType();
					this.getRequest().setAttribute("madelName6", modelName6);
				}
				this.getRequest().setAttribute("divineLand", divineLand);
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
