package com.ty.school.conroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.school.dto.Student;
import com.ty.school.services.StudentServices;
@WebServlet(value = "/student")
public class CreateStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setPhone(phone);

		StudentServices services = new StudentServices();
		Student savedStudent = services.saveStudent(student);
		if (savedStudent != null) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("sufi", savedStudent);

			RequestDispatcher dispatcher = req.getRequestDispatcher("viwe");
			dispatcher.forward(req, resp);
		} else {
			String html = "<html><body><h1>Sorry data not added Re-enter</h1></body></html>";
			RequestDispatcher dispatcher = req.getRequestDispatcher("createStudent.jsp");
			dispatcher.include(req, resp);
		}

	}
}
