package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.util.LoginProcess;
import com.util.User;

/**
 * Servlet Filter implementation class SignupFilter
 */
public class SignupFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SignupFilter() {
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
		String email = request.getParameter("txtemail");
		String password = request.getParameter("txtpassword");
		String userType=request.getParameter("usertype");
		String confirmPassword=request.getParameter("txtconfirmpassword");

		email = email.trim();
		password = password.trim();
		confirmPassword=confirmPassword.trim();
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		
		if(!(password.equals(confirmPassword))) {
			out.print("worng confirm password");
			rd=request.getRequestDispatcher("/jsps/signup.jsp");
			rd.include(request, response);
		}
		
		LoginProcess loginProcess=new LoginProcess();
		boolean emailValidation=loginProcess.validateEmail(email);
		boolean passwordValidation=loginProcess.validatePassword(password);
		
		if(!(emailValidation==true)) {
			out.print("invalid email pattern");
			rd=request.getRequestDispatcher("/jsps/signup.jsp");
			rd.include(request, response);
		}
		else if(!(passwordValidation==true)){
			out.print("invalid password pattern");
			rd=request.getRequestDispatcher("/jsps/signup.jsp");
			rd.include(request, response);
		}
		// pass the request along the filter chain
		else {
		User user=new User(email, password, userType);
		request.setAttribute("user", user);	
		chain.doFilter(request, response);
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
