package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.RedVideo;
import com.future.partymember.util.PageCut;

public interface IRedVideoDao {
	boolean addVideo(RedVideo rv);

	List<RedVideo> getAll();

	RedVideo get(int id);
	List<RedVideo> getNew(int num);
	List<RedVideo> getList(int first,int num);

	void delete(int id);


	//视频浏览次数加一
	boolean updatewatchNumById(int rv_Id);
	

	PageCut<RedVideo> getPC(int pageSize,int curr);

}
