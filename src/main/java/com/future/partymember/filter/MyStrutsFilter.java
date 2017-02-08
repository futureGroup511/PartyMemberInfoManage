package com.future.partymember.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

/**
 *自定义一个Struts过滤器  用于富文本编辑器
 *@author 丁赵雷  
 */
@WebFilter("/MyStrutsFilter")
public class MyStrutsFilter extends StrutsPrepareAndExecuteFilter implements Filter {
       

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws IOException, ServletException {

		
        HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response=(HttpServletResponse)res;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        //不过滤的url    
        String url = request.getRequestURI();    
        
 
        if ((request.getSession().getServletContext().getContextPath()+"/ueditor1_4_3/jsp/controller.jsp").equals(url)) {  //注意路径  
        	
            chain.doFilter(req, res);    
        }else{    

            super.doFilter(req, res, chain);    
        }  
	}


}
