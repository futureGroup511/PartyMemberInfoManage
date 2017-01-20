package com.future.partymember.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IEPRModelDao;
import com.future.partymember.entity.EPRModel;
import com.future.partymember.service.IEPRModelService;

/*
* @author 宋民举 860080937@qq.com  
* @date 2017年1月20日 上午10:17:31 
* @description 
*/

@Service("ePRModelService")
public class EPRModelService implements IEPRModelService{

	@Resource
	private IEPRModelDao ePRModelDao;
	
	@Override
	public void hander(EPRModel[] eprModels) {
		// TODO Auto-generated method stub
		ePRModelDao.hander(eprModels);
	}

}
