package com.future.partymember.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
*@author 焦祥宇
*/
public class SwitchTime {
	public static String switchTime(long time) {
		long hours = (time % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (time % (1000 * 60 * 60)) / (1000 * 60);
		long seconds = (time % (1000 * 60)) / 1000;
		if(minutes==0){
			return seconds + "秒";
		}
		else if(hours==0){
			return minutes + "分钟" + seconds + "秒";
		}
		else{
			return hours + "小时" + minutes + "分钟" + seconds + "秒";
		}		
	}
	public static Date strToDate(String str){
		SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd");
		try {
			return s.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	/*
	public static void main(String[] args) {
		Date date=strToDate(19970813+"");
		System.out.println(date.getTime());
	}
	*/
}
