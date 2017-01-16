package com.future.partymember.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;



/*
*@author 焦祥宇
*/
public class SwitchTime {
	public static String switchTime(long time) {
		int hours =(int)( (time % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
		int minutes = (int)((time % (1000 * 60 * 60)) / (1000 * 60));
		int seconds = (int)((time % (1000 * 60)) / 1000);
		
/*		//以下丁赵雷修改
		Calendar cal = Calendar.getInstance(); 
		
		String pmiTime=partyMemberInfo.getLearnTime();//党员原来的学习时长
		
		if(pmiTime!=null&&!pmiTime.equals("")){
			Date d= SwitchTime.strToDate(pmiTime);
			cal.setTime(d);
			cal.roll(Calendar.SECOND, seconds);
			cal.roll(Calendar.MINUTE, minutes);
			cal.roll(Calendar.HOUR, hours);
			cal.getTime();
		}*/
		
		
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
		SimpleDateFormat s = null;
		if(str.length()==8){
			s=new SimpleDateFormat("yyyyMMdd");
		}else if(str.length()==10){
			s=new SimpleDateFormat("yyyy-MM-dd");
		}else{
			return null;
		}
		try {
			return s.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	//String to 年月日时分秒
	public static Date strToTime(String str){
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try {			
			return s.parse(str.replace('T',' '));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	public static String dateToStr(Date d){
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");	
		return s.format(d);				
	}
	/*
	public static void main(String[] args) {
		Date date=strToDate(19970813+"");
		System.out.println(date.getTime());
	}
	*/
	
	
	
}
