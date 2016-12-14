package com.future.partymember.dao.impl;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IRedVideoDao;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.util.PageCut;

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
		return this.getEntityLimitList("from RedVideo order by id desc", 0, num);
	}

	@Override
	public List<RedVideo> getList(int first, int num) {
		// TODO Auto-generated method stub
		return this.getEntityLimitList("from RedVideo order by id desc", first, num);
	}

	@Override

	public void delete(int id) {
		// TODO Auto-generated method stub
		if(this.getEntity(id)!=null){
			this.deleteEntity(this.getEntity(id));
		}
	}	

	public boolean updatewatchNumById(int rv_Id) {
		RedVideo redvideo=new RedVideo();
		redvideo=this.getEntity(rv_Id);
		redvideo.setWatchNum(redvideo.getWatchNum()+1);
		return this.updateEntity(redvideo);

	}

	@Override
	public PageCut<RedVideo> getPC(int pageSize, int curr) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from RedVideo";
		int count = ((Long) this.uniqueResult(hql)).intValue();
		PageCut<RedVideo> pc = new PageCut<RedVideo>(curr, pageSize, count);
		pc.setData(this.getEntityLimitList("from RedVideo", curr, pageSize));
		
		return pc;
	}

}
