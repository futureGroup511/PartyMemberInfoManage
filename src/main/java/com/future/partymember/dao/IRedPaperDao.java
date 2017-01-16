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
	//根据名字精确查询
	public List<RedPaper> findPaperByNameOne(String name);
	//根据文章类别分类查询 只取前五条
	public List<RedPaper> findPaperByType();
	//文章的阅读次数加一
	public boolean updatePaperReadNum(int rp_id);
	//查询当前id的下一条内容
	public List<RedPaper> getNextRecordById(int id, int typeId);
	//查询当前id的上一条内容
	public List<RedPaper> getPrevRecordById(int id, int typeId);
	
	//查询符合条件的最后一条内容
	public List<RedPaper> getLastRecordById( int typeId);
	//查询符合条件的第一条内容
	public List<RedPaper> getFristRecordById(int typeId);
}
