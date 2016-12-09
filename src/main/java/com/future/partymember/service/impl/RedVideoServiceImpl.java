package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IRedVideoDao;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.service.IRedVideoService;

@Service
public class RedVideoServiceImpl implements IRedVideoService{
	@Resource
	private IRedVideoDao redVideoDao;
	@Override
	public boolean addVideo(RedVideo rv) {
		// TODO Auto-generated method stub
		return redVideoDao.addVideo(rv);
	}
	@Override
	public List<RedVideo> getAll() {
		// TODO Auto-generated method stub
		return redVideoDao.getAll();
	}
	@Override
	public RedVideo get(int id) {
		// TODO Auto-generated method stub
		return redVideoDao.get(id);
	}
	@Override
	public List<RedVideo> getNew(int num) {
		// TODO Auto-generated method stub
		return redVideoDao.getNew(num);
	}
	@Override
	public List<RedVideo> getList(int first, int num) {
		// TODO Auto-generated method stub
		return redVideoDao.getList(first, num);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		redVideoDao.delete(id);
	}

}
