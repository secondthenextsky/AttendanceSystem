package com.attendance.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.attendance.bean.Student;
import com.attendance.bean.Teacher;
import com.attendance.service.StudentService;
import com.attendance.service.TeacherService;
import com.attendance.service.impl.StudentServiceImpl;
import com.attendance.service.impl.TeacherServiceImpl;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService = new TeacherServiceImpl();
	private StudentService studentService = new StudentServiceImpl();
       
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
		case "query":
			query(request,response);
			break;
		case "record":
			record(request,response);
			break;
		default:
			break;
		}
	}

	private void record(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		if(teacher==null) {
			request.setAttribute("message", "您未登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		String dateString = request.getParameter("date");
		if(dateString==null||dateString.trim().equals("")) {
			request.setAttribute("message", "请选择日期");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("date", dateString);
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			date = new Date();
		}
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		int status = Integer.parseInt(request.getParameter("status"));
		studentService.record(studentId,date,status);
		response.sendRedirect(request.getContextPath()+"/TeacherServlet?method=query&date="+dateString);
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String dateString = request.getParameter("date");
		if(dateString==null||dateString.trim().equals("")) {
			request.setAttribute("message", "请选择日期");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("date", dateString);
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			date = new Date();
		}
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		if(teacher==null) {
			request.setAttribute("message", "您未登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		List<Student> students = studentService.getStudentsByTeacher(teacher.getId(),date);
		request.getSession().setAttribute("students", students);
		response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
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
		Date date = new Date();
		List<Student> students = studentService.getStudentsByTeacher(teacher.getId(),date);
		request.getSession().setAttribute("students", students);
		response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
