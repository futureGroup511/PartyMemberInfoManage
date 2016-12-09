package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.RedVideo;

public interface IRedVideoDao {
	boolean addVideo(RedVideo rv);

	List<RedVideo> getAll();

	RedVideo get(int id);
	List<RedVideo> getNew(int num);
	List<RedVideo> getList(int first,int num);
	void delete(int id);
}
