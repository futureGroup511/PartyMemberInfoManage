package com.future.partymember.util;

/*
*@author 焦祥宇
*/
public class SwitchTime {
	public static String switchTime(long time) {
		long hours = (time % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (time % (1000 * 60 * 60)) / (1000 * 60);
		long seconds = (time % (1000 * 60)) / 1000;
		return hours + "小时" + minutes + "分钟" + seconds + "秒";
	}
}
