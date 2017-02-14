package com.future.partymember.action.manager;
import java.util.Date;

/*
* @author 宋民举 860080937@qq.com  
* @date 2016年12月16日 上午11:31:44 
* @description 
*/
import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.Inform;
import com.future.partymember.entity.ManagerInfo;
import com.future.partymember.util.PageCut;
public class InformAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int page=1;
	private Inform inform;
	public String execute(){
		PageCut<Inform> pc=informService.getPCByNew(page, 8);
		this.getRequest().setAttribute("pc", pc);
		return "manage";
	}
	public String add(){
		return "add";
	}
	public String addDo(){
		if(inform==null||inform.getTitle().length()<2||inform.getContent().length()<2){
			this.getRequest().setAttribute("remind","标题和内容不能小于2个字");
			return "add";
		}
		ManagerInfo managerInfo=(ManagerInfo)this.getRequest().getSession().getAttribute("user");
		inform.setAddresser(managerInfo.getUsername());
		inform.setSendDate(new Date());
		inform.setSenderId(managerInfo.getId());
		inform.setSenderType(0);
		informService.addInform(inform);
		
		this.getRequest().setAttribute("remind","添加成功");
		return "add";
	}
	public String delete(){
		if(inform==null||inform.getInfo_Id()<0){
			this.getRequest().setAttribute("remind", "请正确操作");
			return this.execute();
		}
		informService.deleteInform(inform.getInfo_Id());
		this.getRequest().setAttribute("remind","删除成功；");
		return this.execute();
	}
	public String change(){
		this.getRequest().setAttribute("inform",informService.getById(inform.getInfo_Id()));
		return "change";
	}
	public String changeDo(){
		Inform i=informService.getById(inform.getInfo_Id());
		if(i==null){
			this.getRequest().setAttribute("remind", "更改失败");
			return this.change();
		}
		i.setTitle(inform.getTitle());
		i.setContent(inform.getContent());
		i.setInfo_tag(inform.getInfo_tag());
		informService.updateInform(i);
		this.getRequest().setAttribute("remind", "更改成功");
		return this.change();
	}
	public String getNew(){
		return null;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Inform getInform() {
		return inform;
	}
	public void setInform(Inform inform) {
		this.inform = inform;
	}
}