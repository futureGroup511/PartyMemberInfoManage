package com.future.partymember.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;



/*
*@author 焦祥宇
*/
public class SwitchTime {
	public static String switchTime(long time) {
	    Integer ss = 1000;  
	    Integer mi = ss * 60;  
	    Integer hh = mi * 60;  
	    Integer dd = hh * 24;  
	  
	    Long day = time / dd;  
	    Long hour = day*24+(time - day * dd) / hh;  
	    Long minute = (time - hour * hh) / mi;
	    Long second = (time -  hour * hh - minute * mi) / ss;
	   // Long milliSecond = time - day * dd - hour * hh - minute * mi - second * ss;  
	      
	    StringBuffer sb = new StringBuffer();  
/*	    if(day > 0) {  
	        sb.append(day+"天");  
	    }  */
	    if(hour > 0) {  
	        sb.append(hour+"小时");  
	    }  
	    if(minute > 0) {  
	        sb.append(minute+"分");  
	    }  
	    if(second > 0) {  
	        sb.append(second+"秒");  
	    }  
/*	    if(milliSecond > 0) {  
	        sb.append(milliSecond+"毫秒");  
	    } */ 
	    return sb.toString();  
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
	public static String dateToTimeStr(Date d){
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm");	
		return s.format(d);				
	}
	/*
	public static void main(String[] args) {
		Date date=strToDate(19970813+"");
		System.out.println(date.getTime());
	}
	*/
	
	
}
