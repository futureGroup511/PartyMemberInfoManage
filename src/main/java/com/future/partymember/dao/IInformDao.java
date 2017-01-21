package com.future.partymember.dao;



import java.util.List;

import com.future.partymember.entity.Inform;
import com.future.partymember.util.PageCut;

public interface IInformDao {
	public void addInform(Inform inform);

	public void updateInform(Inform inform);

	public void deleteInform(int id);

	PageCut<Inform> getPCByNew(int curr, int pageSize);
	
	//获取hql  Query，业务由service填写
	PageCut<Inform> getQuery(int curr, int pageSize,String hql,String hqlCount,Object ...objects);
	
	PageCut<Inform> getPCByNew(int curr,int pageSize,String search);
	
	Inform getById(int id);
	
	public List<Inform> getNew(int size);

}
