package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.RedPaperType;

public interface IRedPaperTypeDao {
	//查询所有
	public List<RedPaperType> getAllPaperType();
	//删除文章版块
	public int deletePaperType(int id);
	//添加文章版块
	public boolean addPaperType(RedPaperType r);
	//修改版本
	public boolean updatePaperType(RedPaperType r);
	//根据id查询
	public RedPaperType findById(int id);

}
