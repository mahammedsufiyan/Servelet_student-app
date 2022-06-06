package com.ty.school.services;

import java.util.List;

import com.ty.school.dao.StudentDao;
import com.ty.school.dto.Student;

public class StudentServices {
	
	StudentDao dao = new StudentDao();
	
	public Student saveStudent(Student student) {
		
		return dao.saveStudent(student);
	}
	
	public List<Student> getAllStudents(){
		return dao.getAllStudents();
	}
	
	public Student updateStudent(Student student, int student_id) {
		return dao.updateStudent(student, student_id);
	}
	
	public boolean deleteStudent(int student_id) {
		return dao.deleteStudent(student_id);
	}


}
