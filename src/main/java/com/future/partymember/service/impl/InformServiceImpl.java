package com.future.partymember.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IInformDao;
import com.future.partymember.entity.Inform;
import com.future.partymember.service.IInformService;
import com.future.partymember.util.PageCut;

@Service
public class InformServiceImpl implements IInformService{

	@Resource
	private IInformDao informDao;
	@Override
	public void addInform(Inform inform) {
		// TODO Auto-generated method stub
		informDao.addInform(inform);
		
	}

	@Override
	public void updateInform(Inform inform) {
		// TODO Auto-generated method stub
		informDao.updateInform(inform);
	}

	@Override
	public void deleteInform(int id) {
		// TODO Auto-generated method stub
		informDao.deleteInform(id);
	}

	@Override
	public PageCut<Inform> getPCByNew(int curr, int pageSize) {
		// TODO Auto-generated method stub
		return informDao.getPCByNew(curr, pageSize);
	}
}