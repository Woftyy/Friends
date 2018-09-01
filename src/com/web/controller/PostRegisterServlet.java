package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.IUserService;
import com.service.impl.UserServiceImpl;
import com.util.MsgException;

/*
 * 
 * @author 杨译
 * 
 *  处理用户注册
 * 
 * */
@WebServlet(name = "PostRegisterServlet", urlPatterns = { "/PostRegisterServlet" })
public class PostRegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		// TODO Auto-generated method stub
	
			request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		 String password=request.getParameter("password");
		 String sex=request.getParameter("sex");
		 String email=request.getParameter("email");
		 String username=request.getParameter("username");
		 IUserService iUserService=new UserServiceImpl();
		 if (username.isEmpty()||password.isEmpty()) {
			 request.setAttribute("msg", "请输入用户名或密码");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
		}
		 
	 if(iUserService.IsUserExist(username)) {//如果user存在
			    request.setAttribute("msg", "用户名已存在!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
		     }else {//如果不存在
		    	 iUserService.insertUser(username, email, password, sex);
				 response.getWriter().write("恭喜您注册成功!3秒回到主页....");
		       response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
		     }
	}
	
	
}