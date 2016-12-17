package com.future.partymember.service;

import java.util.List;

import com.future.partymember.entity.RedPaperType;

public interface IRedPaperTypeService {
	//查询所有
	public List<RedPaperType> getAllPaperType();
	//删除文章版块
	public int deletePaperType(int id);
	//添加文章版块
	public boolean addPaperType(RedPaperType r);
	//修改版本
	public boolean updatePaperType(RedPaperType r);

}
