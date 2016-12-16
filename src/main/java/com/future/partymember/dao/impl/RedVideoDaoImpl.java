package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IRedVideoDao;
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
		
		RedVideo redvideo1=this.getEntity(rv_Id);
		redvideo1.setWatchNum(redvideo1.getWatchNum()+1);
		return this.updateEntity(redvideo1);

	}

	@Override
	public PageCut<RedVideo> getPC(int pageSize, int curr) {
		String hql = "select count(*) from RedVideo";
		int count = ((Long) this.uniqueResult(hql)).intValue();
		PageCut<RedVideo> pc = new PageCut<RedVideo>(curr, pageSize, count);
		pc.setData(this.getEntityLimitList("from RedVideo", curr, pageSize));
		
		return pc;
	}

	//模糊查询视频
	@Override
	public List<RedVideo> findByName(String name) {
		String hql="from RedVideo as rv where rv.name like :name";
		Query query=getSession().createQuery(hql);
		query.setString("name", "%" + name + "%");
		return query.list();
	}

}
