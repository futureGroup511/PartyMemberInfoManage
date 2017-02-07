package com.future.partymember.action.manager;
/*
* @author 宋民举 860080937@qq.com  
* @date 2017年1月19日 上午9:30:09 
* @description 
*/

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.StartTest;
import com.future.partymember.util.PageCut;

public class StartTestAction extends BaseAction{
	
	private int page=1;
	private int id;
	
	public String startTestLog(){
		
		if(page<1){
			page=1;
		}
		String search=(String)this.getRequest().getAttribute("search");
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
		for(StartTest st:pCut.getData()){
			st.setStartTime(st.getStartTime().replaceAll("T"," "));
			st.setEndTime(st.getEndTime().replaceAll("T", " "));
		}
		this.getRequest().setAttribute("pc",pCut);
		this.getRequest().setAttribute("search",search);
		return "startTestLog";
	}
	
	public String deleteAll(){
		if(examLogService.deleteAll()){
			examPerRecordService.deleteAll();
			startTestService.deleteAll();
			this.getRequest().setAttribute("remind", "删除成功。");
		}else{
			this.getRequest().setAttribute("remind", "删除失败。");
		}
		return this.startTestLog();
	}
	
	public String startTestDel(){
		if(id<1){
			return null;
		}
		if(startTestService.deleteById(id)){
			this.getRequest().setAttribute("remind", "删除成功。");
		}else{
			this.getRequest().setAttribute("remind", "删除失败。");
		}
		
		return this.startTestLog();
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
