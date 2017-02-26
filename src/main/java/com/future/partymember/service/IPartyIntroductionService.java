package com.future.partymember.service;

import java.util.List;

import com.future.partymember.entity.PartyIntroduction;

public interface IPartyIntroductionService {
	//得到所有
	public List<PartyIntroduction> findAll();
	//修改简介
	public boolean updatePartyIntroduction(PartyIntroduction p);

}
