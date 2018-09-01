package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IMomentDao;
import com.dao.impl.MomentDaoImpl;
import com.service.IMomentService;
import com.service.impl.MomentServiceImpl;

/**
 * 
 * @author 杨译
 *  处理动态
 */
@WebServlet(name = "PostPublishServlet", urlPatterns = { "/PostPublishServlet" })
public class PostPublishServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostPublishServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IMomentDao iMomentDao=new MomentDaoImpl();
		IMomentService iMomentService=new MomentServiceImpl();
		HttpSession session = request.getSession();
		String username =(String) session.getAttribute("username");
		int uid = (int) session.getAttribute("id");
		System.out.println("当前用户为"+uid);
		String img= request.getParameter("img");
		String content=request.getParameter("content");
		if (content.isEmpty()) {
		    request.setAttribute("msg", "请输入内容");
				request.getRequestDispatcher("PersonalCenter.jsp").forward(request, response);
		}else {
			iMomentService.insertMoment(uid, content, img);
			request.setAttribute("msg", "发布成功");
			request.getRequestDispatcher("PersonalCenter.jsp").forward(request, response);
		}
		
	}
}
