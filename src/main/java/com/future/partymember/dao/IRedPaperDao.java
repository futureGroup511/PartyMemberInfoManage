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
	//分页查询，带上标题搜索，搜索可为空
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize,String search);
	
	
	/**
	 * 下面这个方法是书记和党员所用
	 * 分页查询
	 * @param curr
	 * @param pageSize
	 * @return
	 */
	//分页查询，带上标题搜索，搜索可为空  权限不可为空
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize,String search, int rp_tag);
	
	//分页查询， 按类别
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize,int paperTypeId, String search);
	//根据id查询
	public RedPaper getById(int id);
	//根据名字精确查询
	public List<RedPaper> findPaperByNameOne(String name);
	//根据文章类别分类查询 只取前五条
	public List<RedPaper> findPaperByType();
	//根据文章类别id进行查询，获得最新的num条
	public List<RedPaper> getPaperByTpId(int tp_Id,int num);
	//文章的阅读次数加一
	public boolean updatePaperReadNum(int rp_id);
	
	
	/**
	 * 下面这四个方法是根据文章类别进行检索
	 * @param id
	 * @param typeId
	 * @return
	 */
	//查询当前id的下一条内容
	public List<RedPaper> getNextRecordById(int id, int typeId);
	//查询当前id的上一条内容
	public List<RedPaper> getPrevRecordById(int id, int typeId);
	
	//查询符合条件的最后一条内容
	public List<RedPaper> getLastRecordById( int typeId);
	//查询符合条件的第一条内容
	public List<RedPaper> getFristRecordById(int typeId);
	
	
	
	/**
	 * 这四个根据阅读权限进行检索
	 * @param id
	 * @return
	 */
	//查询当前id的下一条内容
	public List<RedPaper> getNextRecordById(int id , String search);
	//查询当前id的上一条内容
	public List<RedPaper> getPrevRecordById(int id, String search);
	
	//查询符合条件的最后一条内容
	public List<RedPaper> getLastRecordById(String search );
	//查询符合条件的第一条内容
	public List<RedPaper> getFristRecordById(String search);
	
		//获取最新文章
		/**
		 * @param size 获取的条数，注意，当数据库总数少于size时，获取条数会小于size
		 * @return
		 */
		public List<RedPaper> getNew(int size);
		
		//获取最热文章
		/**
		 * @param size 获取的条数，注意，当数据库总数少于size时，获取条数会小于size
		 * @return
		 */
		public List<RedPaper> getHot(int size);
}
