package com.future.partymember.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IRedVideoDao;
import com.future.partymember.entity.RedVideo;

@Repository
public class RedVideoDaoImpl extends BaseDao<RedVideo> implements IRedVideoDao {

	@Override
	public boolean addVideo(RedVideo rv) {
		return this.saveEntity(rv);
	}

	@Override
	public List<RedVideo> getAll() {
		// TODO Auto-generated method stub
		return this.getEntityList("from RedVideo");
	}

	@Override
	public RedVideo get(int id) {
		// TODO Auto-generated method stub
		return this.getEntity(id);
	}

	@Override
	public List<RedVideo> getNew(int num) {
		// TODO Auto-generated method stub
		return this.getEntityLimitList("from RedVideo order by id desc", 1, num);
	}

	@Override
	public List<RedVideo> getList(int first, int num) {
		// TODO Auto-generated method stub
		return this.getEntityLimitList("from RedVideo", first, num);
	}

}
