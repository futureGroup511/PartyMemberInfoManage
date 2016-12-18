package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
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

}
