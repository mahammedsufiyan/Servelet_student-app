package com.ty.school.conroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.school.services.StudentServices;
@WebServlet(value = "/delete")
public class DeleteStudent extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id= Integer.parseInt(req.getParameter("id"));
	StudentServices services = new StudentServices();
	services.deleteStudent(id);
	
	RequestDispatcher dispatcher  = req.getRequestDispatcher("viwe");
	dispatcher.forward(req, resp);
		
	}
}
