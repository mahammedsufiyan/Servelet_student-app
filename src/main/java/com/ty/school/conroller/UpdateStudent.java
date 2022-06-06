package com.ty.school.conroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.school.dto.Student;
import com.ty.school.services.StudentServices;
@WebServlet(value = "/update")
public class UpdateStudent extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher1 = req.getRequestDispatcher("update.jsp");
		dispatcher1.forward(req, resp);
		
		int  id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setPhone(phone);
		
		StudentServices services = new StudentServices();
		Student updatedStudent = services.updateStudent(student, id);
		
		if(updatedStudent != null) {
			req.setAttribute("stu", updatedStudent);
			RequestDispatcher dispatcher = req.getRequestDispatcher("viwe");
			dispatcher.forward(req, resp);
		}
		else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("Cannot updated retry");
			RequestDispatcher dispatcher = req.getRequestDispatcher("update");
			dispatcher.include(req, resp);
		}
	}
}
