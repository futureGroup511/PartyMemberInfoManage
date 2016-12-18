package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IRedPaperTypeDao;
import com.future.partymember.entity.RedPaperType;
import com.future.partymember.service.IRedPaperTypeService;
@Service
public class RedPaperTypeServiceImpl implements IRedPaperTypeService {
	@Resource
	private IRedPaperTypeDao iRedPaperTypeDao;
	
	@Override
	public List<RedPaperType> getAllPaperType() {
		return iRedPaperTypeDao.getAllPaperType();
	}

	@Override
	public int deletePaperType(int id) {
		return iRedPaperTypeDao.deletePaperType(id);
	}

	@Override
	public boolean addPaperType(RedPaperType r) {
		return iRedPaperTypeDao.addPaperType(r);
	}

	@Override
	public boolean updatePaperType(RedPaperType r) {
		return iRedPaperTypeDao.updatePaperType(r);
	}

	@Override
	public RedPaperType findById(int id) {
		return iRedPaperTypeDao.findById(id);
	}

}
