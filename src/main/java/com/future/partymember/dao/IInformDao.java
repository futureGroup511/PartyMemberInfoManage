package com.future.partymember.dao;

import org.hibernate.Query;

import com.future.partymember.entity.Inform;
import com.future.partymember.util.PageCut;

public interface IInformDao {
	public void addInform(Inform inform);

	public void updateInform(Inform inform);

	public void deleteInform(int id);

	PageCut<Inform> getPCByNew(int curr, int pageSize);
	
	//获取hql  Query，业务由service填写，objects参数已设置
	Query getQuery(String hql,Object ...objects);

	
	Inform getById(int id);

}
