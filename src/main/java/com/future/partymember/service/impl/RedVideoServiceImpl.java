package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IRedVideoDao;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.service.IRedVideoService;
import com.future.partymember.util.PageCut;

@Service
public class RedVideoServiceImpl implements IRedVideoService{
	@Resource
	private IRedVideoDao redVideoDao;
	@Override
	public boolean addVideo(RedVideo rv) {
		return redVideoDao.addVideo(rv);
	}
	@Override
	public List<RedVideo> getAll() {
		return redVideoDao.getAll();
	}
	@Override
	public RedVideo get(int id) {
		return redVideoDao.get(id);
	}
	@Override
	public List<RedVideo> getNew(int num) {
		return redVideoDao.getNew(num);
	}
	@Override 
	public List<RedVideo> getList(int first, int num) {
		return redVideoDao.getList(first, num);
	}
	@Override
	public void delete(int id) {
		redVideoDao.delete(id);
	}
	public boolean updatewatchNumById(int rv_Id) {
		
		return redVideoDao.updatewatchNumById(rv_Id);

	}
	@Override
	public PageCut<RedVideo> getPC(int pageSize, int curr) {
		return redVideoDao.getPC(pageSize, curr);
	}
	
	//添加人 丁赵雷
	@Override
	public List<RedVideo> findByName(String name) {
		return redVideoDao.findByName(name);
	}
	@Override
	public List<RedVideo> getNextRecordById(int id) {
		return redVideoDao.getNextRecordById(id);
	}
	@Override
	public List<RedVideo> getPrevRecordById(int id) {
		return redVideoDao.getPrevRecordById(id);
	}
	@Override
	public List<RedVideo> getLastRecordById() {
		return redVideoDao.getLastRecordById();
	}
	@Override
	public List<RedVideo> getFristRecordById() {
		return redVideoDao.getFristRecordById();
	}
	/* (non-Javadoc)
	 * @see com.future.partymember.service.IRedVideoService#getPC(int, int, java.lang.String)
	 * 根据名字搜索返回分页。宋
	 */
	@Override
	public PageCut<RedVideo> getPC(int pageSize, int curr, String search) {
		// TODO Auto-generated method stub
		return redVideoDao.getPC(pageSize, curr,search);
	}
	@Override
	public List<RedVideo> getRecommend(int num) {		
		return redVideoDao.getRecommend(num);
	}
	@Override
	public List<RedVideo> getHot(int size) {
		// TODO Auto-generated method stub
		return redVideoDao.getHot(size);
	}

}
