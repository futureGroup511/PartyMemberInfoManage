package com.future.partymember;

import com.future.partymember.util.SwitchTime;

public class Test {
	public static void main(String[] args) { 
		String[] strs="/PartyMemberInfoManage/secretary/partySecretary_login".split("/");
		for (String string : strs) {
			System.out.println(string);
		}
		
		String s=strs[3].split("_")[1];
		System.out.println(s);
	}
}
