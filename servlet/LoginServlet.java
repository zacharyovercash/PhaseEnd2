package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.services.UserService;
import com.user.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in the servlet");
		String email = request.getParameter("email");
		String password= request.getParameter("password");
		User user = new User(email,password,"");
		
		UserService userService = new UserService();
		boolean found =userService.login(user);
		if(found==true) {
			HttpSession session = request.getSession();
			session.setAttribute("sesname", request.getParameter("email"));
			response.sendRedirect("loginsuccess.jsp");
		}
		else {
			response.sendRedirect("index.html");
			System.out.println("Login Failed");
		}
		
	}

}
