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
 * @author ����
 * 
 *  �����û�ע��
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
			 request.setAttribute("msg", "�������û���������");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
		}
		 
	 if(iUserService.IsUserExist(username)) {//���user����
			    request.setAttribute("msg", "�û����Ѵ���!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
		     }else {//���������
		    	 iUserService.insertUser(username, email, password, sex);
				 response.getWriter().write("��ϲ��ע��ɹ�!3��ص���ҳ....");
		       response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
		     }
	}
	
	
}