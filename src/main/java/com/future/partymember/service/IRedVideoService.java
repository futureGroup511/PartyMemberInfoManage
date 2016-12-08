package com.future.partymember.service;

import java.util.List;

import com.future.partymember.entity.RedVideo;

public interface IRedVideoService {
	boolean addVideo(RedVideo rv);
	List<RedVideo> getAll();
	RedVideo get(int id);
	List<RedVideo> getNew(int num);
	List<RedVideo> getList(int first,int num);
}
