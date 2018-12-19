package com.attendance.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.attendance.bean.Teacher;
import com.attendance.service.TeacherService;
import com.attendance.service.impl.TeacherServiceImpl;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService = new TeacherServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String method = request.getParameter("method");
		if (method == null || method.trim().equals("")) {
			return;
		}
		switch (method) {
		case "login":
			login(request,response);
			break;
		default:
			break;
		}
	}

	/**
	 * 登录
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("number");
		String password = request.getParameter("password");
		if(number==null||number.trim().equals("")) {
			request.setAttribute("message", "请输入工号");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().equals("")) {
			request.setAttribute("message", "请输入密码");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		Teacher teacher = teacherService.getByNumberAndPassword(number, password);
		if(teacher==null) {
			request.setAttribute("message", "用户名或密码错误");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("teacher", teacher);
		response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
