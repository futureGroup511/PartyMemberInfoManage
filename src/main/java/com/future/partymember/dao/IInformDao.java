package com.future.partymember.dao;

import com.future.partymember.entity.Inform;
import com.future.partymember.util.PageCut;

public interface IInformDao{
	public void addInform(Inform inform);
	public void updateInform(Inform inform);
	public void deleteInform(int id);
	PageCut<Inform> getPCByNew(int curr,int pageSize);

}
