package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.RedVideo;

public interface IRedVideoDao {
	boolean addVideo(RedVideo rv);

	List<RedVideo> getAll();

	RedVideo get(int id);
	List<RedVideo> getNew(int num);
	List<RedVideo> getList(int first,int num);
<<<<<<< Updated upstream
	void delete(int id);
=======
	//视频浏览次数加一
	boolean updatewatchNumById(int rv_Id);
>>>>>>> Stashed changes
}
