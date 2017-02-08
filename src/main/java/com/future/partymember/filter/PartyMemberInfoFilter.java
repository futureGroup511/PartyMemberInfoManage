package com.future.partymember.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class UserInfoFilter
 */

public class PartyMemberInfoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PartyMemberInfoFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response = (HttpServletResponse) resp;
        //不过滤的url    
        String url = request.getRequestURI();           
        Object userId=request.getSession().getAttribute("userId");        
        if(userId!=null){
        	chain.doFilter(request, response);
        }else{
			// 用户不存在,踢回登录页面
			String returnUrl = request.getContextPath() + "/index.jsp";
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8"); // 转码
			response
					.getWriter()
					.println(
							"<script language=\"javascript\">alert(\"您还没有登录，请先登录!\");"
							+ "if(window.opener==null){window.top.location.href=\""
									+ returnUrl+ "\";}else{window.opener.top.location.href=\""
									+ returnUrl
									+ "\";window.close();}</script>");
			return;
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

