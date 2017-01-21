package com.future.partymember.service;

import java.util.List;

import com.future.partymember.entity.Inform;
import com.future.partymember.util.PageCut;
import com.opensymphony.xwork2.util.finder.ClassFinder.Info;

public interface IInformService {
	public void addInform(Inform inform);
	public void updateInform(Inform inform);
	public void deleteInform(int id);
	
	PageCut<Inform> getPCByNew(int curr,int pageSize);
	
	PageCut<Inform> getPCByNew(int curr,int pageSize,String search);
	
	Inform getById(int id);
	//书记管理通知的方法
	PageCut<Inform> getQuery(int curr, int pageSize,Object ...objects);
	//书记查看通知的方法
	PageCut<Inform> getInformList(int curr, int pageSize,Object ...objects);
	public List<Inform> getNew(int size);
}
