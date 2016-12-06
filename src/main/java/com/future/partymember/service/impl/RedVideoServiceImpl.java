package com.future.partymember.service.impl;

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

}
