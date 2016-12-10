package com.future.partymember.action.partymember;

import java.util.ArrayList;
import java.util.List;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.RedVideo;
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

	private PartyMemberInfo partyMemberInfo;

	// 查询党员个人信息
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

	// 观看红色视频
	public String viewVideos() throws Exception {
		List<RedVideo> videosList = new ArrayList<RedVideo>();
		videosList = redVideoService.getAll();
		this.getRequest().setAttribute("videosList",

				videosList);
		return "viewVideos";
	}

	/*
	 * //查询个人党费交纳
	 * 
	 * public String getPartyFree(){
	 * 
	 * return "getPartyFree"; }
	 */

	/**
	 * 更新党员的学习时间 丁赵雷 ---焦祥宇修改过
	 */
	public void updateLearnTime() {
		/* PartyMemberInfo p=(PartyMemberInfo)session.get("partyMember"); */// 从session获得用户信息
		/* int ptm_id=p.getPtm_Id(); */// 用户id
		partyMemberInfo = partyMemberInfoService.getPartyMemberInfoById(1);

		long time = Integer.parseInt(getRequest().getParameter("time"));
		System.out.println("time" + time);
		time = time + partyMemberInfo.getLearnTime();
		partyMemberInfo.setLearnTime(time);
		partyMemberInfoService.updatePartyMemberInfo(partyMemberInfo);

	}

	public void setPartyMemberInfo(PartyMemberInfo partyMemberInfo) {
		this.partyMemberInfo = partyMemberInfo;
	}

	public PartyMemberInfo getPartyMemberInfo() {
		return partyMemberInfo;
	}

}
