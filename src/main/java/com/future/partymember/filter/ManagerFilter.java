package com.future.partymember.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.future.partymember.entity.ManagerInfo;

import freemarker.ext.servlet.HttpRequestParametersHashModel;

/**
 * Servlet Filter implementation class ManagerFilter
 */
@WebFilter("/manage/*")
public class ManagerFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ManagerFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpServletRequest req=(HttpServletRequest)request;
		System.out.println(req.getRequestURI());
		if(req.getRequestURI().equals(req.getContextPath()+"/manage/index_login")||req.getRequestURI().equals(req.getContextPath()+"/manage/index_loginDo")){
			chain.doFilter(request, response);
			return;
		}
		Object user=req.getSession().getAttribute("user");
		if(user!=null && user instanceof ManagerInfo){
			chain.doFilter(request, response);
			return;
		}else{
			HttpServletResponse res=(HttpServletResponse)response;
			res.sendRedirect(req.getContextPath()+"/manage/index_login");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
