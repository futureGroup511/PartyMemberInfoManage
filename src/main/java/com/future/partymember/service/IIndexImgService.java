package com.future.partymember.service;

import java.util.List;

import com.future.partymember.entity.IndexImage;


public interface IIndexImgService {
	
	
	//获取前num条记录，新记录在前
	List<IndexImage> getByNew(int num);
	boolean addIndexImg(IndexImage indexImage);
	IndexImage getById(int id);
	boolean deleteById(int id);
}
