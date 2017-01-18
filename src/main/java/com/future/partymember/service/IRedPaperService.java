package com.future.partymember.service;

import java.util.List;

import com.future.partymember.entity.RedPaper;
import com.future.partymember.util.PageCut;

/**
 * 红色文章
 * @author 丁赵雷 
 *
 */
public interface IRedPaperService {
	//添加文章
	public boolean addRedPaper(RedPaper rp);
	//删除
	public int deleteRedPaper(int id);
	//根据标题模糊查询
	public List<RedPaper> findPaperByName(String name);
	//根据标题精确查找
	public List<RedPaper> findPaperByNameOne(String name);
	//修改
	public boolean updateRedPaper(RedPaper rp);
	//分页查询
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize);
	
	//分页查询，带上标题搜索，搜索可为空
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize,String search);
	//根据id查询
	public RedPaper getById(int id);
	//根据文章类别进行查询,每个类别只取最新的五条
	public List<RedPaper> findPaperByType();
	//文章阅读次数加一
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
