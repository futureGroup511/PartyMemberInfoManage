package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IIndexImageDao;
import com.future.partymember.entity.IndexImage;
import com.future.partymember.service.IIndexImgService;

@Service("indexImageService")
public class IndexImageService extends BaseDao<IndexImage> implements IIndexImgService{

	@Resource
	private IIndexImageDao indexImageDao;
	
	@Override
	public List<IndexImage> getByNew(int num) {
		// TODO Auto-generated method stub
		return indexImageDao.getByNew(num);
	}

	@Override
	public boolean addIndexImg(IndexImage indexImage) {
		// TODO Auto-generated method stub
		return indexImageDao.addIndexImg(indexImage);
	}

	@Override
	public IndexImage getById(int id) {
		// TODO Auto-generated method stub
		return indexImageDao.getById(id);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return indexImageDao.deleteById(id);
	}

	

}
