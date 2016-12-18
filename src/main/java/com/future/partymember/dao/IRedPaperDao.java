package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.RedPaper;
import com.future.partymember.util.PageCut;

public interface IRedPaperDao {
	//添加文章
	public boolean addRedPaper(RedPaper rp);
	//删除
	public int deleteRedPaper(int id);
	//模糊查询
	public List<RedPaper> findPaperByName(String name);
	//修改
	public boolean updateRedPaper(RedPaper rp);
	//分页查询
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize);
	//根据id查询
	public RedPaper getById(int id);

}
