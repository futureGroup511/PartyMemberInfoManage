package com.future.partymember.action.manager;

import com.future.partymember.base.BaseAction;

/*
* @author 宋民举 860080937@qq.com  
* @date 2017年1月19日 上午11:24:56 
* @description 
*/
public class ExamPerRecordAction extends BaseAction{
	
	private int id;
	private int page;
	private String search;
	
	public String manage(){
		if(page<1){
			page=1;
		}
		/*
		String encode = this.getRequest().getParameter("encode");
		if("1".equals(encode)){
			try {
				byte[] str1=search.getBytes("iso8859-1");
				search=new String(str1, "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		PageCut<ExamPerRecord> pCut=startTestService.getPC(page, 10, search);
		String s1=String.format("<span class=\"search\">%s</span>",search);
		if(search == null || "".equals(search)){
			
		}else{
			for(StartTest e:pCut.getData()){
				e.setPaperName(e.getPaperName().replaceAll(search, s1));
			}
		}
		this.getRequest().setAttribute("pc",pCut);
		this.getRequest().setAttribute("search",search);*/
		return "manage";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
