package com.future.partymember.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IRedPaperTypeDao;
import com.future.partymember.entity.RedPaperType;

@Repository
public class RedPaperTypeDaoImpl extends BaseDao<RedPaperType> 
	implements IRedPaperTypeDao {

	//获得所有文章版块
	@Override
	public List<RedPaperType> getAllPaperType() {
		String hql="from RedPaperType";
		return getEntityList(hql);
	}

	
	//删除
	@Override
	public boolean deletePaperType(int id) {
		String hql="delete RedPaperType rpt where rpt.rpt_Id=?";
		
		return false;
	}

	@Override
	public boolean addPaperType(RedPaperType r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePaperType(RedPaperType r) {
		// TODO Auto-generated method stub
		return false;
	}

}
