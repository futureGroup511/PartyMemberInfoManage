package com.future.partymember.util;


import java.util.ArrayList;
import java.util.List;

import com.future.partymember.entity.RedPaper;

/**
 * 文章的工具类
 * @author 丁赵雷
 *
 */
public class PaperUtil {
	
	/**
	 * 控制文章标题的长度
	 * @param titleLength 处理后的文章标题长度
	 * @param paperList
	 * @return PaperList
	 */
	
	public static List<RedPaper> titleLength(List<RedPaper> paperList,int titleLength){
		String t="";
		
		List<RedPaper> list=new ArrayList<RedPaper>();
		
		for (RedPaper redPaper : paperList) {
			
			if(redPaper.getTitle().length()>titleLength){
				t=redPaper.getTitle().substring(0, titleLength-2)+"...";
				redPaper.setTitle(t);
				list.add(redPaper);
			}else{
				list.add(redPaper);
			}
		}
		
		return list;
	}
}
