package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IRedVideoDao;
import com.future.partymember.entity.RedPaper;
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
		return this.getEntityList("from RedVideo");
	}

	@Override
	public RedVideo get(int id) {
		return this.getEntity(id);
	}

	@Override
	public List<RedVideo> getNew(int num) {
		return this.getEntityLimitList("from RedVideo order by id desc", 0, num);
	}

	@Override
	public List<RedVideo> getRecommend(int num) {	
		return this.getEntityLimitList("from RedVideo order by watchNum desc", 0, num);
	}
	
	@Override
	public List<RedVideo> getList(int first, int num) {
		return this.getEntityLimitList("from RedVideo order by id desc", first, num);
	}

	@Override

	public void delete(int id) {
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
		pc.setData(this.getEntityLimitList("from RedVideo", (curr-1)*pageSize, pageSize));
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

	
	//查询当前id的下一条记录
	@Override
	public List<RedVideo> getNextRecordById(int id) {
		String sql="select * from red_video rv where rv_Id>? order by rv_Id asc limit 1";
		return executeSQLQuery(RedVideo.class,sql, id);
	}

	//查询当前id的上一条记录
	@Override
	public List<RedVideo> getPrevRecordById(int id) {
		String sql="select * from red_video rv where rv_Id<? order by rv_Id desc limit 1";
		return executeSQLQuery(RedVideo.class,sql, id);
	}

	//查询符合条件的最后一条记录
	@Override
	public List<RedVideo> getLastRecordById() {
		String sql="select * from red_video rv order by rv_Id desc limit 1";
		return executeSQLQuery(RedVideo.class,sql);
	}

	//查询符合记录的最后一条记录
	@Override
	public List<RedVideo> getFristRecordById() {
		String sql="select * from red_video rv  order by rv_Id asc limit 1";
		return executeSQLQuery(RedVideo.class,sql);
	}

	@Override
	public PageCut<RedVideo> getPC(int pageSize, int curr, String search) {

		if(search==null || search.length()==0){
			return this.getPC(pageSize, curr);
		}
		
		String hql = "select count(*) from RedVideo as rv where rv.name like :search";
		
		Query query=this.getSession().createQuery(hql);
		
		String format=String.format("%%%s%%", search);
		query.setString("search",format);
		int count = ((Long)query.uniqueResult()).intValue();
		
		PageCut<RedVideo> pc = new PageCut<RedVideo>(curr, pageSize, count);
		hql="from RedVideo as rv where rv.name like :search";
		query=this.getSession().createQuery(hql);
		query.setString("search", format);
		query.setFirstResult((curr-1)*pageSize);
		query.setMaxResults(pageSize);
		pc.setData(query.list());
		return pc;
	}

	@Override
	public List<RedVideo> getHot(int size) {
		// TODO Auto-generated method stub
		String hql="from RedVideo as rv order by rv.watchNum desc";
		return this.getEntityLimitList(hql,0,size);
	}

}
