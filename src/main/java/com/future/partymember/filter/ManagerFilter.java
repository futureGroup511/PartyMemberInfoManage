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
@WebFilter("/manage/*")  //丁赵雷注销的
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
		
		
		
        
		
		HttpServletRequest req=(HttpServletRequest)request;
		req.setCharacterEncoding("UTF-8");
		String search = req.getParameter("search");
		
		HttpServletResponse res = (HttpServletResponse)response;
		res.setContentType("text/html;charset=utf8");
		//不过滤的url    

		
		if(search !=null && search.length()>0){
			search = new String(search.getBytes("ISO8859-1"), "utf8");
		}
		req.setAttribute("search",search);
		if(req.getRequestURI().equals(req.getContextPath()+"/manage/index_login")||req.getRequestURI().equals(req.getContextPath()+"/manage/index_loginDo")){
			chain.doFilter(request, response);
			return;
		}
		Object user=req.getSession().getAttribute("user");
		if(user!=null && user instanceof ManagerInfo){
			chain.doFilter(request, response);
			return;
		}else{
			
			String loginUrl = req.getSession().getServletContext().getContextPath() + "/manage/index_login";
			response
			.getWriter()
			.println(
					"<script language=\"javascript\">\n top.location.href = '"
					+ loginUrl + "' ; \n</script>");
			//res.sendRedirect(req.getContextPath()+"/manage/index_login");
		}
	}

	
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
