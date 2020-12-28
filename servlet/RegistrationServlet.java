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


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		User user = new User(request.getParameter("email"),request.getParameter("password"),request.getParameter("name"));
		userService.Registration(user);
		HttpSession session = request.getSession();
		session.setAttribute("sesname", request.getParameter("name"));
		response.sendRedirect("registersuccess.jsp");
	}

}
