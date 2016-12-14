package com.future.partymember.action.partymember;

import java.util.ArrayList;
import java.util.List;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.entity.WatchVideoRecord;
import com.future.partymember.util.PageCut;
import com.future.partymember.util.SwitchTime;

/*
 * 党员信息控制层
 * @author 焦祥宇
 */
public class PartyMemberAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int page=1;

	private PartyMemberInfo partyMemberInfo;//从表单获得党员对象
	/*private int id;//视频id
*/	// 查询党员个人信息
	public String seekPartyMemberInfo() throws Exception {
		partyMemberInfo = partyMemberInfoService.getPartyMemberInfoById(1);
		//学习时间		
		String time=SwitchTime.switchTime(partyMemberInfo.getLearnTime());
		this.getRequest().setAttribute("learnTime",time);
		this.getRequest().setAttribute("partyMember", partyMemberInfo);
		return "seekPartyMemberInfo";
	}

	// 修改党员个人信息时，先获得党员信息以便修改
	public String getInfoBeforeUpdate() throws Exception {
		partyMemberInfo = partyMemberInfoService.getPartyMemberInfoById(1);
		String time=SwitchTime.switchTime(partyMemberInfo.getLearnTime());
		this.getRequest().setAttribute("learnTime",time);
		this.getSession().put("partyMember", partyMemberInfo);
		return "getInfoBeforeUpdate";
	}

	// 修改党员个人基本信息
	public String updatePartyMemberInfo() throws Exception {
		PartyMemberInfo oldPartyMemberInfo = (PartyMemberInfo) this.getSession().get("partyMember");
		partyMemberInfo.updatePartyMemberInfo(oldPartyMemberInfo.getPtm_Id(), oldPartyMemberInfo.getAccount(),
				oldPartyMemberInfo.getSort(), oldPartyMemberInfo.getLoginDate(), oldPartyMemberInfo.getJoinPartyDate(),
				oldPartyMemberInfo.getDuties(), oldPartyMemberInfo.getIntroducer(), oldPartyMemberInfo.getPartyBranch(),
				oldPartyMemberInfo.getLearnTime());
		// 附件待定
		partyMemberInfo.setIdAccessory("####");
		// 判断是否修改了密码
		if (partyMemberInfo.getPassword().equals("******")) {
			partyMemberInfo.setPassword(oldPartyMemberInfo.getPassword());
		}

		// 密码加密还没加

		Boolean bool = partyMemberInfoService.updatePartyMemberInfo(partyMemberInfo);
		if (bool == true) {
			this.getRequest().setAttribute("updateMsg", "修改成功");
		} else {
			this.getRequest().setAttribute("updateMsg", "修改失败");
		}
		return "updatePartyMemberInfo";
	}

	// 红色视频
	public String viewVideos() throws Exception {
		PageCut<RedVideo> pc =redVideoService.getPC(12, page);
		this.getRequest().setAttribute("pc", pc);
		System.out.println(pc.getData().size());
		List<RedVideo> videosList = new ArrayList<RedVideo>();
		videosList = redVideoService.getAll();
		this.getRequest().setAttribute("videosList",videosList);
		return "viewVideos";
	}

	//看视频
	public String viewing() throws Exception{
		//从路径获得视频id
		int videoId=Integer.valueOf(this.getRequest().getParameter("videoId"));
		
		//获得视频观看记录
		WatchVideoRecord watchVideoRecord=watchVideoRecordService.getWVR(videoId, 1);
		if(watchVideoRecord!=null)
			this.getRequest().setAttribute("currentTime", watchVideoRecord.getCurrentTime());
		System.out.println(watchVideoRecord);
		//视频浏览次数加一
		redVideoService.updatewatchNumById(videoId);	
		
		//播放视频
		this.getRequest().setAttribute("video",redVideoService.get(videoId));		
		return "viewing";
	}
	
	/*
	 * //查询个人党费交纳
	 * 
	 * public String getPartyFree(){
	 * 
	 * return "getPartyFree"; }
	 */

	/**
	 * 更新党员的学习时间和视频播放记录历史  丁赵雷 ---焦祥宇修改过
	 */
	public void updateLearnTime()  throws Exception{
		/* PartyMemberInfo p=(PartyMemberInfo)session.get("partyMember"); */// 从session获得用户信息
		/* int ptm_id=p.getPtm_Id(); */// 用户id
		partyMemberInfo = partyMemberInfoService.getPartyMemberInfoById(1);
		
		long time = Integer.parseInt(getRequest().getParameter("time"));
		System.out.println("time" + time);
		
/*		//以下丁赵雷修改
		Calendar cal = Calendar.getInstance(); 
		Date d= SwitchTime.strToDate(partyMemberInfo.getLearnTime());
		cal.setTime(d);
		cal.roll(Calendar.SECOND, time); */
		time = time + partyMemberInfo.getLearnTime();
		String strTime=SwitchTime.switchTime(time);
		partyMemberInfo.setLearnTime(time);
		partyMemberInfo.setStrLearnTime(strTime);
		partyMemberInfoService.updatePartyMemberInfo(partyMemberInfo);
		//视频播放记录历史
		System.out.println("*******视频播放记录历史******");		
		String vt=getRequest().getParameter("currentTime");	
		long currentTime=0;
		if(vt.indexOf(".")>0){
			currentTime=Integer.valueOf(vt.substring(0,vt.indexOf(".")));
		}
		else{
			currentTime =Integer.valueOf(vt);
		}

		System.out.println("currentTime"+currentTime);
		
		int videoId = Integer.valueOf(getRequest().getParameter("videoId"));
		System.out.println("vidoeId:"+videoId);				
		WatchVideoRecord watchVideoRecord;
		watchVideoRecord=watchVideoRecordService.getWVR(videoId, 1);
		System.out.println(watchVideoRecord);
		if(watchVideoRecord==null){
			watchVideoRecord=new WatchVideoRecord();
			watchVideoRecord.setRv_id(videoId);
			watchVideoRecord.setPm_id(1);
			watchVideoRecord.setCurrentTime(currentTime);		
			watchVideoRecordService.addWVR(watchVideoRecord);
		}
		else{
			watchVideoRecord.setRv_id(videoId);
			watchVideoRecord.setPm_id(1);
			watchVideoRecord.setCurrentTime(currentTime);		
			watchVideoRecordService.updateWVR(watchVideoRecord);
		}
	

	}

	public void setPartyMemberInfo(PartyMemberInfo partyMemberInfo) {
		this.partyMemberInfo = partyMemberInfo;
	}

	public PartyMemberInfo getPartyMemberInfo() {
		return partyMemberInfo;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
}
