package com.future.partymember.action.secretary;

import java.util.Date;
import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.Inform;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.entity.WatchVideoRecord;
import com.future.partymember.util.PageCut;
import com.future.partymember.util.SwitchTime;

@Controller(value="partySecretaryAction")
@Scope(value="prototype")
public class PartySecretaryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PartySecretaryInfo partySecretaryInfo;
	private PageCut<?> pageCut; 
	private Inform inform;//用来封装通知消息的
	private int page=1;






	/**
	 * 查看个人信息
	 * @return
	 * @throws Exception
	 */
	public String lookMyself() throws Exception{
		return "lookMyself";
	}
	
	
	//查看通知
	public String lookInform(){
		if(inform.getInfo_Id()!=0){
			Inform i=informService.getById(inform.getInfo_Id());
			this.getRequest().setAttribute("inform", i);
		}
		
		return "lookInform";
	}
	
	
	//通知列表
	public String informList(){
		
		System.out.println("通知列表的分页"+page);
		PageCut<Inform> pc=informService.getInformList(page, 5);
		this.getRequest().setAttribute("pc", pc);
		return "informList";
	}
	
	//修改通知
	public String updateInform(){
		Inform i=informService.getById(inform.getInfo_Id());
		System.out.println("修改通知的id"+inform.getInfo_Id());
		if(inform.getTitle().equals("")||inform.getContent().equals("")){
			this.getRequest().setAttribute("notice", "内容不能为空");
		}else{
			System.out.println("修改通知的内容"+inform.getContent());
			System.out.println("修改通知的标题"+inform.getTitle());
			i.setContent(inform.getContent());
			i.setTitle(inform.getTitle());
			System.out.println(i);
			informService.updateInform(i);//更新通知
			this.getRequest().setAttribute("notice", "修改成功");
		}
		return "updateInform";
	}
	
	
	//删除通知
	public String deleteInform(){
		if(inform.getInfo_Id()!=0){
			informService.deleteInform(inform.getInfo_Id());//删除记录
			this.getRequest().setAttribute("notice", "编号为"+inform.getInfo_Id()+"的通知删除成功");
		}else{
			this.getRequest().setAttribute("notice", "您的操作不合法");
		}

		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		System.out.println("通知的分页"+page);
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		PageCut<Inform> pc=informService.getQuery(page, 5, psi.getPartyBranch());
		this.getRequest().setAttribute("pc", pc);
		return "manageInfom";
	}
	
	
	//通知的分页
	public String paperInform(){
		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		System.out.println("通知的分页"+page);
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		PageCut<Inform> pc=informService.getQuery(page, 5, psi.getPst_Id());
		this.getRequest().setAttribute("pc", pc);
		return "manageInfom";
	}
	
	//发布通知
	public String addInform(){
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		
		if(inform.getTitle().equals("")||inform.getContent().equals("")){
			this.getRequest().setAttribute("notice", "内容不能为空");
		}else{
			inform.setAddresser(psi.getUsername());
			inform.setSenderType(1);		
			inform.setSendDate(new Date());
			inform.setSenderId(psi.getPst_Id());
			inform.setInfo_tag(7);
			inform.setPartBranch(psi.getPartyBranch());
			informService.addInform(inform);//插入一条记录
			this.getRequest().setAttribute("notice", "发布成功");
		}
		return "addInform";
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
	
	
	//修改个人手机号
	public String updatePhone() throws Exception{
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		String phone = this.getRequest().getParameter("phone");//得到新的手机号
		psi.setPhoneNo(phone);
		partySecretaryInfoService.updatePersonInfo(psi);
		this.getRequest().setAttribute("notice", "修改成功");
		return "lookMyself";
	}
	
	
	//修改个人密码
	public String updatePassword() throws Exception{
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		System.out.println("psi"+psi);

		String password1=(String)this.getRequest().getParameter("password1");//密码
		String password2=(String)this.getRequest().getParameter("password2");//确认密码
		System.out.println("新密码"+password1);
		
		//判断密码必须是字母和数字的组合长度为8到16位
		String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		if(password1.matches(regex)&&password2.matches(regex)&&password1.equals(password2)){
			psi.setPassword(password2);
			partySecretaryInfoService.updatePersonInfo(psi);//更新个人信息
			this.getRequest().setAttribute("notice", "修改成功");
		}else{
			this.getRequest().setAttribute("notice", "两次密码不一致");
		}
		return "updatePassword";
	}
	
	
	//视频列表和分页
	public String videoList(){
		
		return "videoList";
	}
	
	
	//观看视频
	public String lookVideo() throws Exception{
		int id=Integer.parseInt(this.getRequest().getParameter("rv_Id"));//视频id
		
		partySecretaryInfo =(PartySecretaryInfo)session.get("secretary");
		int psiId=partySecretaryInfo.getPst_Id();//书记的id
		
		//获得视频观看记录
		WatchVideoRecord watchVideoRecord=watchVideoRecordService.getWVR(id, psiId,1);
		if(watchVideoRecord!=null)//设置上次观看该视频的时间
			this.getRequest().setAttribute("currentTime", watchVideoRecord.getCurrentTime());
		
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
	
	
	/**
	 * 更新书记的学习时间和视频播放记录历史 丁赵雷 
	 */
	public void updateLearnTime() throws Exception {

		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		
		long time = Integer.parseInt(getRequest().getParameter("time"));//观看视频的时间
		System.out.println("time" + time);

		time = time + psi.getLearnTime();
		String strTime = SwitchTime.switchTime(time);
		System.out.println("书记的学习时长"+strTime);
		psi.setLearnTime(time);
		psi.setStrLearnTime(strTime);
		
		partySecretaryInfoService.updatePersonInfo(psi);//更新个人学习时间
		
		// 视频播放记录历史
		System.out.println("*******视频播放记录历史******");
		String vt = getRequest().getParameter("currentTime");
		long currentTime = 0;
		if (vt.indexOf(".") > 0) {
			currentTime = Integer.valueOf(vt.substring(0, vt.indexOf(".")));
		} else {
			currentTime = Integer.valueOf(vt);
		}

		System.out.println("currentTime" + currentTime);

		int videoId = Integer.valueOf(getRequest().getParameter("videoId"));
		System.out.println("vidoeId:" + videoId);
		WatchVideoRecord watchVideoRecord;
		watchVideoRecord=watchVideoRecordService.getWVR(videoId, psi.getPst_Id(),1);

		System.out.println(watchVideoRecord);
		if (watchVideoRecord == null) {
			watchVideoRecord = new WatchVideoRecord();
			watchVideoRecord.setRv_id(videoId);
			watchVideoRecord.setPm_id(psi.getPst_Id());
			watchVideoRecord.setCurrentTime(currentTime);
			watchVideoRecord.setPartySort(1);
			watchVideoRecordService.addWVR(watchVideoRecord);//添加一条视频播放记录
			
		} else {
			watchVideoRecord.setRv_id(videoId);
			watchVideoRecord.setPm_id(psi.getPst_Id());
			watchVideoRecord.setCurrentTime(currentTime);
			watchVideoRecordService.updateWVR(watchVideoRecord);//更新视频播放记录

		}
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
			if(rpNext!=null){
				RedPaper rp1=rpNext.get(0);
				this.getRequest().setAttribute("next",rp1 );
			}
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
	
	public PageCut<?> getPageCut() {
		return pageCut;
	}

	public void setPageCut(PageCut<?> pageCut) {
		this.pageCut = pageCut;
	}
	
	public Inform getInform() {
		return inform;
	}


	public void setInform(Inform inform) {
		this.inform = inform;
	}
	
	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}



}
