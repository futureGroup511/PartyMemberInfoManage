package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IRedPaperDao;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.service.IRedPaperService;
import com.future.partymember.util.PageCut;
/**
 * 
 * @author 丁赵雷
 *
 */
@Service
public class RedPaperServiceImpl implements IRedPaperService{
	
	@Resource
	private  IRedPaperDao iRedPaperDao;
	
	
	@Override
	public boolean addRedPaper(RedPaper rp) {
		return iRedPaperDao.addRedPaper(rp);
	}

	@Override
	public int deleteRedPaper(int id) {
		return iRedPaperDao.deleteRedPaper(id);
	}

	@Override
	public List<RedPaper> findPaperByName(String name) {
		return iRedPaperDao.findPaperByName(name);
	}

	@Override
	public boolean updateRedPaper(RedPaper rp) {
		return iRedPaperDao.updateRedPaper(rp);
	}

	@Override
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize) {
		return iRedPaperDao.getPCByNew(curr, pageSize);
	}

	@Override
	public RedPaper getById(int id) {
		return iRedPaperDao.getById(id);
	}

	@Override
	public List<RedPaper> findPaperByNameOne(String name) {
		return iRedPaperDao.findPaperByNameOne(name);
	}

	//根据文章类别进行查询,每个类别只取最新的五条
	@Override
	public List<RedPaper> findPaperByType() {
		return iRedPaperDao.findPaperByType();
	}

	//文章的阅读次数加一
	@Override
	public boolean updatePaperReadNum(int rp_id) {
		return iRedPaperDao.updatePaperReadNum(rp_id);
	}

	@Override
	public List<RedPaper> getNextRecordById(int id , int typeId) {
		return iRedPaperDao.getNextRecordById(id, typeId);
	}

	@Override
	public List<RedPaper> getPrevRecordById(int id , int typeId) {
		return iRedPaperDao.getPrevRecordById(id , typeId);
	}

	@Override
	public List<RedPaper> getLastRecordById(int typeId) {
		return iRedPaperDao.getLastRecordById(typeId);
	}

	@Override
	public List<RedPaper> getFristRecordById(int typeId) {
		return iRedPaperDao.getFristRecordById(typeId);
	}

	@Override
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize, String search) {
		return iRedPaperDao.getPCByNew(curr, pageSize, search);
	}

	@Override
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize, int paperTypeId, String search) {
		return iRedPaperDao.getPCByNew(curr, pageSize, paperTypeId,search);
	}

	@Override
	public List<RedPaper> getNew(int size) {
		return iRedPaperDao.getNew(size);
	}

	@Override
	public List<RedPaper> getHot(int size) {
		return iRedPaperDao.getHot(size);
	}

	@Override
	public PageCut<RedPaper> getPCByNew(int curr, int pageSize, String search, int rp_tag) {
		return iRedPaperDao.getPCByNew(curr, pageSize, search, rp_tag);
	}

	@Override
	public List<RedPaper> getNextRecordById(int id, String search) {
		return iRedPaperDao.getNextRecordById(id, search);
	}

	@Override
	public List<RedPaper> getPrevRecordById(int id, String search) {
		return iRedPaperDao.getPrevRecordById(id, search);
	}

	@Override
	public List<RedPaper> getLastRecordById(String search) {
		return iRedPaperDao.getLastRecordById( search);
	}

	@Override
	public List<RedPaper> getFristRecordById(String search) {
		return iRedPaperDao.getFristRecordById( search);
	}

	@Override
	public List<RedPaper> getPaperByTpId(int tp_Id, int num) {
		
		return iRedPaperDao.getPaperByTpId(tp_Id, num);
	}

}
