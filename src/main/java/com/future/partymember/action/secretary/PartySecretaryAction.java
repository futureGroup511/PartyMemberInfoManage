package com.future.partymember.action.secretary;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.util.PageCut;

@Controller(value="partySecretaryAction")
@Scope(value="prototype")
public class PartySecretaryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PartySecretaryInfo partySecretaryInfo;
	private PageCut<PartyMemberInfo> pageCut; 
	



	/**
	 * 查看个人信息
	 * @return
	 * @throws Exception
	 */
	public String lookMyself() throws Exception{
		return "lookMyself";
	}
	
	
	//查看所管理的党员信息
	public String lookOfPartyMember() throws Exception{
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		List<PartyMemberInfo>  list=null;
		int curPage =1;
		
		if(pageCut==null){
			list=partyMemberInfoService.findAllPartyMemberInfo(psi,curPage,15);//一页15条记录
			pageCut=partyMemberInfoService.getPagerCut(15, curPage, psi);
		}else{
			curPage=pageCut.getCurrentPage();
			
			list=partyMemberInfoService.findAllPartyMemberInfo(psi,curPage,15);//一页15条记录
			pageCut=partyMemberInfoService.getPagerCut(15, curPage, psi);
		}

		
		this.getRequest().setAttribute("PMIlist", list);
		return "lookOfPartyMember";
	}
	
	
	//修改个人信息
	public String updataPerson() throws Exception{
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		System.out.println("psi"+psi);
		String password=partySecretaryInfo.getPassword();//第二次输入的新密码

		String oldPassword=(String)this.getRequest().getParameter("oldPassword");//旧密码
		String password1=(String)this.getRequest().getParameter("password1");//新密码
		System.out.println("新密码"+password1);
		
		//使用正则表达式来检验手机号
		String regex="^[1][358][0-9]\\d{9}$";
		String phoneNo=partySecretaryInfo.getPhoneNo();
		boolean flag=phoneNo.matches(regex);
		if(flag){
			psi.setPhoneNo(phoneNo);
		}else{
			System.out.println("您输入的手机号不合法");
		}
		if(oldPassword.equals(psi.getPassword())){
			if(password.equals(password1)){
				psi.setPassword(password);
			}else{
				System.out.println("两次输入的密码不一致");
			}
		}else{
			System.out.println("旧密码输入错误");
		}

		partySecretaryInfoService.updatePersonInfo(psi);//更新个人信息
		
		return "lookMyself";
	}
	
	
	//观看视频
	public String lookVideo() throws Exception{
		int id=Integer.parseInt(this.getRequest().getParameter("rv_Id"));//视频id
		
		partySecretaryInfo =(PartySecretaryInfo)session.get("secretary");
		int psiId=partySecretaryInfo.getPst_Id();//书记的id
		
		redVideoService.updatewatchNumById(id);//视频观看次数加一
		RedVideo v =redVideoService.get(id);
		this.getRequest().setAttribute("video", v);
		
		//查询第一个和最后一个视频作为临界点
		RedVideo lastVideo=redVideoService.getLastRecordById().get(0);
		RedVideo fristVideo=redVideoService.getFristRecordById().get(0);
		
		//查询上一个 下一个
		if(lastVideo.getRv_Id()==id){
			this.getRequest().setAttribute("next", lastVideo);
			this.getRequest().setAttribute("notice", "后面没有了");			
		}else{
			List<RedVideo> rvNext=redVideoService.getNextRecordById(id);
			RedVideo rv1=rvNext.get(0);
			this.getRequest().setAttribute("next",rv1 );
		}
		
		if(fristVideo.getRv_Id()==id){
			this.getRequest().setAttribute("prev", fristVideo);
			this.getRequest().setAttribute("notice", "前面没有了");
		}else{
			List<RedVideo> rpPrev=redVideoService.getPrevRecordById(id);
			RedVideo rv2=rpPrev.get(0);
			this.getRequest().setAttribute("prev", rv2);
		}

		return "lookVideo";
	}
	
	//阅读文章
	public String lookPaper() throws Exception{
		int id=Integer.parseInt(this.getRequest().getParameter("rp_Id"));
		System.out.println("文章id"+id);
		redPaperService.updatePaperReadNum(id);//文章阅读次数加一
		RedPaper rp=redPaperService.getById(id);
		this.getRequest().setAttribute("paper", rp);
		
		//查询第一篇 最后一篇 作为临界点
		RedPaper lastPaper=redPaperService.getLastRecordById(rp.getPaperTypeId()).get(0);
		RedPaper fristPaper=redPaperService.getFristRecordById(rp.getPaperTypeId()).get(0);
		
		//查询上一篇 下一篇
		if(lastPaper.getRp_Id()==id){
			this.getRequest().setAttribute("next", lastPaper);
			this.getRequest().setAttribute("notice", "后面没有了");			
		}else{
			List<RedPaper> rpNext=redPaperService.getNextRecordById(id,rp.getPaperTypeId());
			RedPaper rp1=rpNext.get(0);
			this.getRequest().setAttribute("next",rp1 );
		}
		
		if(fristPaper.getRp_Id()==id){
			this.getRequest().setAttribute("prev", fristPaper);
			this.getRequest().setAttribute("notice", "前面没有了");
		}else{
			List<RedPaper> rpPrev=redPaperService.getPrevRecordById(id, rp.getPaperTypeId());
			RedPaper rp2=rpPrev.get(0);
			this.getRequest().setAttribute("prev", rp2);
		}

		return "lookPaper";
	}

	public PartySecretaryInfo getPartySecretaryInfo() {
		return partySecretaryInfo;
	}

	public void setPartySecretaryInfo(PartySecretaryInfo partySecretaryInfo) {
		this.partySecretaryInfo = partySecretaryInfo;
	}
	
	public PageCut getPageCut() {
		return pageCut;
	}

	public void setPageCut(PageCut pageCut) {
		this.pageCut = pageCut;
	}

}
