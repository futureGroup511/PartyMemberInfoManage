package com.future.partymember.action.secretary;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.EPRModel;
import com.future.partymember.entity.ExamLog;
import com.future.partymember.entity.ExamPerRecord;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.entity.StartTest;
import com.future.partymember.service.IExamPerRecordService;
import com.future.partymember.service.IStartTestService;
import com.future.partymember.service.ITestPaperService;
import com.future.partymember.util.PageCut;

/**
 * 查询所属党员的考试记录
 * @author 丁赵雷
 *@see 2017-01-20
 */
@Controller(value="testAction")
@Scope(value="prototype")
public class TestAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private PartySecretaryInfo partySecretaryInfo;
	private PageCut<?> pageCut; 
	private int page=1;
	private int id;
	
/*	 testPaperService;
	 examPerRecordService;
	 startTestService;*/




	//查看所有的的考试记录
	public String startTestLog(){
		
		if(page<1){
			page=1;
		}
		String search=this.getRequest().getParameter("search");
		PageCut<StartTest> pCut=startTestService.getPC(page, 10, search);
		
		String s1=String.format("<span class=\"search\">%s</span>",search);
		
		//防止前台提交参数错误，注释掉高亮搜索词的功能。
		
		/*
		if(search == null || "".equals(search)){
			
		}else{
			for(StartTest e:pCut.getData()){
				e.setPaperName(e.getPaperName().replaceAll(search, s1));
			}
		}
		*/
		this.getRequest().setAttribute("pc",pCut);
		this.getRequest().setAttribute("search",search);
		return "startTestLog";
	}
	
	
	//查看参加这次考试的党员的成绩记录
	public String log(){
		if(page<1){
			page=1;
		}
		
		String partyBranch=(String) session.get("partyBranch");
		String search=this.getRequest().getParameter("search");
		String encode = this.getRequest().getParameter("encode");
		if("1".equals(encode)){
			try {
				byte[] str1=search.getBytes("iso8859-1");
				search=new String(str1, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		PageCut<ExamLog> pCut=examLogService.getPC(page, 10, search,partyBranch);
		String s1=String.format("<span class=\"search\">%s</span>",search);
		if(search == null || "".equals(search)){
			
		}else{
			for(ExamLog e:pCut.getData()){
				e.setPaperName(e.getPaperName().replaceAll(search, s1));
				e.setPartyMemberName(e.getPartyMemberName().replaceAll(search, s1));
			}
		}
		this.getRequest().setAttribute("pc",pCut);
		this.getRequest().setAttribute("search",search);
		return "log";
	}
	
	
	//查看某个党员详细的试题记录
	public String info(){
		if(id<1){
			return null;
		}
		ExamLog examLog= examLogService.getById(id);
		if(examLog == null){
			return null;
		}
		List<ExamPerRecord> examPerRecords=examPerRecordService.getExamPerRecordsByUserId(
				examLog.getPartyMemberId(), examLog.getPaper_Id(), examLog.getPartySort());
		if(examPerRecords==null || examPerRecords.size() < 1){
			this.getRequest().setAttribute("remind","找不到记录");
			return "info";
		}
		EPRModel[] eprModels=new EPRModel[examPerRecords.size() - 1];
		
		for(int i=0;i < eprModels.length;i++){
			eprModels[i]=new EPRModel();
			eprModels[i].setExamPerRecord(examPerRecords.get(i));
			eprModels[i].setTestPaper(testPaperService.getTestPaper(examPerRecords.get(i).getTp_Id()));
			eprModels[i].setQuestion(questionService.getById(examPerRecords.get(i).getQt_Id()));
			eprModels[i].setAnswer(examPerRecords.get(i).getAnswer());
			if(examPerRecords.get(i).getPartySort()==0){
				try{
					eprModels[i].setPersonName(partyMemberInfoService.getPartyMemberInfoById(
							examPerRecords.get(i).getPt_Id()).getUsername());
				}catch(Exception e){
					e.printStackTrace();
					eprModels[i].setPersonName("未知");
				}
			}else{
				try{
					eprModels[i].setPersonName(partySecretaryInfoService.findById(examPerRecords.get(i).getPt_Id()).getUsername());
				}catch(Exception e){
					e.printStackTrace();
					eprModels[i].setPersonName("未知");
				}
			}
			
		}
		this.getRequest().setAttribute("eprModels", eprModels);
		return "info";
	}
	
	
	public PartySecretaryInfo getPartySecretaryInfo() {
		return partySecretaryInfo;
	}
	public void setPartySecretaryInfo(PartySecretaryInfo partySecretaryInfo) {
		this.partySecretaryInfo = partySecretaryInfo;
	}
	public PageCut<?> getPageCut() {
		return pageCut;
	}
	public void setPageCut(PageCut<?> pageCut) {
		this.pageCut = pageCut;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
