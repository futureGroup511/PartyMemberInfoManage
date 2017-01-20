package com.future.partymember.service;
/*
* @author 宋民举 860080937@qq.com  
* @date 2017年1月20日 上午10:15:28 
* @description 
*/

import org.springframework.stereotype.Service;

import com.future.partymember.entity.EPRModel;

@Service("ePRModelService")
public interface IEPRModelService {
	//处理
	void hander(EPRModel[] eprModels);
}
