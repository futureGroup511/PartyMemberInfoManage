package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IRedPaperDao;
import com.future.partymember.entity.Inform;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.util.PageCut;
/**
 * 文章的数据访问层
 * @author 丁赵雷
 *
 */
@Repository
public class RedPaperDaoImpl extends BaseDao<RedPaper> implements IRedPaperDao {

	@Override
	public boolean addRedPaper(RedPaper rp) {
		return saveEntity(rp);
	}

	@Override
	public int deleteRedPaper(int id) {
		String hql="delete RedPaper rp where rp.rp_Id=?";
		return executeUpdate(hql, id);
	}

	@Override
	public List<RedPaper> findPaperByName(String name) {
		String hql="from RedPaper as rp where rp.title like :name";
		Query query=getSession().createQuery(hql);
		query.setString("name", "%" + name + "%");
		return query.list();
	}

	@Override
	public boolean updateRedPaper(RedPaper rp) {
		return updateEntity(rp);
	}

	
	public int getNum() {
		String hql="select count(*) from RedPaper";
		return ((Long) this.uniqueResult(hql)).intValue();
	}

	//分页查询
	@Override
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize) {
		int first=(curr-1)*pageSize;
		List<RedPaper> list=this.getEntityLimitList("from RedPaper order by rp_Id desc", first,pageSize);
		PageCut<RedPaper> pc=new PageCut<>(curr,pageSize,this.getNum());
		pc.setData(list);
		return pc;	
	}

	@Override
	public RedPaper getById(int id) {
		return getEntity(id);
	}

	//根据名字精确查找
	@Override
	public List<RedPaper> findPaperByNameOne(String name) {
		String hql="from RedPaper rp where rp.title=?";
		return getEntityList(hql,name);
	}

	
	//根据文章类别进行查询,每个类别只取最新的五条
	@Override
	public List<RedPaper> findPaperByType() {
		String sql="select * FROM red_paper a WHERE ( SELECT count( 1 )  FROM red_paper b"
				+ " WHERE a.paper_type_id = b.paper_type_id  AND b.rp_Id >= a.rp_Id ) <=5 and rp_tag=1"
				+ " ORDER BY paper_type_id ASC";
		return executeSQLQuery(RedPaper.class, sql);
	}

	
	//文章阅读次数加一
	@Override
	public boolean updatePaperReadNum(int rp_id) {
		RedPaper rp=getEntity(rp_id);
		rp.setReadNum(rp.getReadNum()+1);
		
		return updateEntity(rp);
	}

	//查询当前id的下一条记录
	@Override
	public List<RedPaper> getNextRecordById(int id,int typeId) {
		String sql="select * from red_paper rp where rp_Id>? and rp.paper_type_id=?"
				+ " and rp.rp_tag=1 order by rp_Id asc limit 1";
		return executeSQLQuery(RedPaper.class,sql, id, typeId);
	}

	//查询当前id的上一条记录
	@Override
	public List<RedPaper> getPrevRecordById(int id, int typeId) {
		String sql="select * from red_paper rp where rp.rp_Id<? and rp.paper_type_id=? "
				+ " and rp.rp_tag=1 order by rp.rp_Id desc limit 1";
		return executeSQLQuery(RedPaper.class,sql, id,typeId);
	}

	//查询最后一条记录
	@Override
	public List<RedPaper> getLastRecordById(int typeId) {
		String sql="select * from red_paper as rp where rp.paper_type_id=? and rp.rp_tag=1 order by rp.rp_Id desc limit 1";
		return executeSQLQuery(RedPaper.class,sql, typeId);
	}

	@Override
	public List<RedPaper> getFristRecordById(int typeId) {
		String sql="select * from red_paper as rp where rp.paper_type_id=? and rp.rp_tag=1 order by rp.rp_Id asc limit 1";
		return executeSQLQuery(RedPaper.class,sql, typeId);
	}

	@Override
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize, String search) {
		// TODO Auto-generated method stub
		System.out.println(search);
		if(search == null || search.length()==0){
			return this.getPCByNew(curr, pageSize);
		}
		String hql="select count(*) from RedPaper as rp where rp.title like :search";
		Query query= this.getSession().createQuery(hql);
		query.setString("search","%"+search+"%");
		int count = ((Long)query.uniqueResult()).intValue();
		PageCut<RedPaper> pCut=new PageCut<>(curr,pageSize,count);
		hql="from RedPaper as rp where rp.title like :search";
		query= this.getSession().createQuery(hql);
		query.setString("search","%"+search+"%");
		query.setFirstResult((curr-1)*pageSize);
		query.setMaxResults(pageSize);
		pCut.setData(query.list());
		return pCut;
		
	}
	
	
	public int getNum( int paperTypeId) {
		String hql="select count(*) from RedPaper where  paperTypeId=?";
		return ((Long) this.uniqueResult(hql,paperTypeId)).intValue();
	}
	
	
	//分页查询按文章类别的id
	@Override
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize, int paperTypeId) {
		int first=(curr-1)*pageSize;
		String hql="from RedPaper where paperTypeId=? order by rp_Id desc";
		List<RedPaper> list=this.getEntityLimitList(hql, first,pageSize,paperTypeId);
		PageCut<RedPaper> pc=new PageCut<>(curr,pageSize,this.getNum(paperTypeId));
		pc.setData(list);
		return pc;	
	}

	@Override
	public List<RedPaper> getNew(int size) {
		String hql="from RedPaper as rp order by rp.releaseDate desc";
		return this.getEntityLimitList(hql, 0, size);
	}

	@Override
	public List<RedPaper> getHot(int size) {
		String hql="from RedPaper as rp order by rp.readNum desc";
		return this.getEntityLimitList(hql, 0, size);
	}
	

}
