package com.future.partymember.service.impl;

import java.util.List;

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
		informDao.addInform(inform);
		
	}

	@Override
	public void updateInform(Inform inform) {
		informDao.updateInform(inform);
	}

	@Override
	public void deleteInform(int id) {
		informDao.deleteInform(id);
	}

	@Override
	public PageCut<Inform> getPCByNew(int curr, int pageSize) {
		return informDao.getPCByNew(curr, pageSize);
	}

	@Override
	public Inform getById(int id) {
		return informDao.getById(id);
	}

	//书记在管理通知时所用到的方法
	@Override
	public PageCut<Inform> getQuery(int curr, int pageSize ,Object ...objects) {
		String hql="from Inform where senderId=? and senderType =1 order by info_Id desc";
		String hqlCount="select count(*) from Inform where senderId=? and senderType =1";
		return informDao.getQuery(curr, pageSize, hql, hqlCount,objects);
	}

	//书记  和党员在查看通知时用到的方法
	@Override
	public PageCut<Inform> getInformList(int curr, int pageSize, Object... objects) {
		String hql="from Inform where  info_tag=? or info_tag=? order by info_Id desc";
		String hqlCount="select count(*) from Inform where info_tag=? or info_tag=?";
		return informDao.getQuery(curr, pageSize, hql, hqlCount,objects);
	}

	@Override
	public PageCut<Inform> getPCByNew(int curr, int pageSize, String search) {
		return informDao.getPCByNew(curr, pageSize);
	}

	@Override
	public List<Inform> getNew(int size) {
		return informDao.getNew(size);
	}
	
	
/*	public PageCut<Inform> getQuery(int curr, int pageSize ,Object ...objects) {
		String hql="from Inform where partBranch=? and senderType =1 order by info_Id desc";
		String hqlCount="select count(*) from Inform where partBranch=? and senderType =1";
		return informDao.getQuery(curr, pageSize, hql, hqlCount,objects);
	}*/

	
	
}