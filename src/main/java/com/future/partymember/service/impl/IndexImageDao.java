package com.future.partymember.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.future.partymember.base.BaseDao;
import com.future.partymember.entity.IndexImage;
import com.future.partymember.service.IIndexImgService;

@Service
public class IndexImageDao extends BaseDao<IndexImage> implements IIndexImgService{

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
		this.deleteEntity(this.getEntity(id));
		return true;
	}

}
