package com.future.partymember.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IInformDao;
import com.future.partymember.entity.Inform;
import com.future.partymember.util.PageCut;

@Repository
public class InformDaoImpl extends BaseDao<Inform> implements IInformDao {

	@Override
	public void addInform(Inform inform) {
		// TODO Auto-generated method stub
		this.saveEntity(inform);
		
	}
	public int getNum() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Inform";
		return ((Long) this.uniqueResult(hql)).intValue();
	}

	@Override
	public void updateInform(Inform inform) {
		// TODO Auto-generated method stub
		this.updateEntity(inform);
	}

	@Override
	public void deleteInform(int id) {
		// TODO Auto-generated method stub
		this.deleteEntity(this.getEntity(id));
	}

	@Override
	public PageCut<Inform> getPCByNew(int curr, int pageSize) {
		// TODO Auto-generated method stub
		int first=(curr-1)*pageSize;
		List<Inform> list=this.getEntityLimitList("from Inform", first,pageSize);
		PageCut<Inform> pc=new PageCut<>(curr,pageSize,this.getNum());
		pc.setData(list);
		return pc;
		
	}

}
