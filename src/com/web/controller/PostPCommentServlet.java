package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.ICommentService;
import com.service.IUserService;
import com.service.impl.CommentServiceImpl;
import com.service.impl.UserServiceImpl;

/*
 * 处理评论发布
 * 
 */

@WebServlet(name = "PostPCommentServlet", urlPatterns = { "/PostPCommentServlet" })
public class PostPCommentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostPCommentServlet() {
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
		String content = request.getParameter("content");
		String mid = request.getParameter("mid");
		String uid = request.getParameter("uid");
		ICommentService iCommentService = new CommentServiceImpl();
	   iCommentService.insertComment(Long.valueOf(mid), Integer.valueOf(uid), content);
	   System.out.println("插入成功");
	   request.setAttribute("msg", "评论成功!");
		request.getRequestDispatcher("PersonalCenter.jsp").forward(request, response);
	}
}
