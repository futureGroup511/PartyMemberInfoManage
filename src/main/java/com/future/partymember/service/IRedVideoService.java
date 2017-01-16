package com.future.partymember.service;

import java.util.List;

import com.future.partymember.entity.RedVideo;
import com.future.partymember.util.PageCut;

public interface IRedVideoService {
	boolean addVideo(RedVideo rv);
	List<RedVideo> getAll();
	RedVideo get(int id);
	List<RedVideo> getNew(int num);
	List<RedVideo> getList(int first,int num);
	void delete(int id);
	//视频浏览次数加一
	boolean updatewatchNumById(int rv_Id);
	PageCut<RedVideo> getPC(int pageSize,int curr);
	
	//模糊搜索视频根据名字
	public List<RedVideo> findByName(String name);
	
	//查询当前id的下一条内容
	public List<RedVideo> getNextRecordById(int id);
	//查询当前id的上一条内容
	public List<RedVideo> getPrevRecordById(int id);
	
	//查询符合条件的最后一条内容
	public List<RedVideo> getLastRecordById();
	//查询符合条件的第一条内容
	public List<RedVideo> getFristRecordById();
}
