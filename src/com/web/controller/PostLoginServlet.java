package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.IUserService;
import com.service.impl.UserServiceImpl;


/**
 * 
 * @author 杨译
 *    处理登录
 */
@WebServlet(name = "PostLoginServlet", urlPatterns = { "/PostLoginServlet" })
public class PostLoginServlet extends HttpServlet{private static final long serialVersionUID = 1L;

/**
 * @see HttpServlet#HttpServlet()
 */
public PostLoginServlet() {
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
	 String username=request.getParameter("username");
	 IUserService iUserService=new UserServiceImpl();
	 IUserDao iUserDao=new UserDaoImpl();
	 if (username.isEmpty()||password.isEmpty()) {
		 request.setAttribute("msg", "请输入用户名或密码");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
	}
	 if (iUserService.IsUserExist(username)) {//如果user存在
		 if(!iUserService.IsPassWordRight(username, password)) {
			    request.setAttribute("msg", "密码错误!");//返回主页面
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
		     }else {
		    	 User user= iUserDao.queryByName(username);
		    	 HttpSession session = request.getSession();
		    	 session.setAttribute("username", username); 
		    	 session.setAttribute("password", password);//登入成功
		    	 session.setAttribute("id", user.getId());//登入成功
		    	  response.sendRedirect("PersonalCenter.jsp"); 
		    	
		     }
	}else {
		request.setAttribute("msg", "用户名不存在!");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		return;
	}
 
	     
}

}