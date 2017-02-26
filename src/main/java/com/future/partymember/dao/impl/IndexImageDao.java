package com.future.partymember.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IIndexImageDao;
import com.future.partymember.entity.IndexImage;

@Repository
public class IndexImageDao extends BaseDao<IndexImage> implements IIndexImageDao {
String hql1="from IndexImage order by id desc";
	
	@Override
	public List<IndexImage> getByNew(int num) {
		// TODO Auto-generated method stub
		return this.getEntityLimitList(hql1, 0, num);
	}

	@Override
	public boolean addIndexImg(IndexImage indexImage) {
		// TODO Auto-generated method stub
		return this.saveEntity(indexImage);
	}

	@Override
	public IndexImage getById(int id) {
		// TODO Auto-generated method stub
		return this.getEntity(id);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		IndexImage indexImage = this.getEntity(id);
		if(indexImage == null){
			return false;
		}
		this.deleteEntity(indexImage);
		return true;
	}
}
