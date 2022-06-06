package com.ty.school.conroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.school.dto.Student;
import com.ty.school.services.StudentServices;
@WebServlet(value = "/viwe")
public class ViweStudent extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		StudentServices services = new StudentServices();
		List<Student> students = services.getAllStudents();
		
		if(students != null) {
			req.setAttribute("list", students);
			RequestDispatcher dispatcher = req.getRequestDispatcher("viwe.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("createStudent.jsp");
			dispatcher.include(req, resp);
		}
	}
}
