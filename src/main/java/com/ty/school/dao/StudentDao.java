package com.ty.school.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.school.dto.Student;

public class StudentDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager  entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Student saveStudent(Student student) {
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}
	
	public List<Student> getAllStudents(){
		String jpql = "SELECT s FROM Student s";
		Query query = entityManager.createQuery(jpql);
		
		List<Student> students = query.getResultList();
		if(students != null) {
			return students;
		}
		return null;
	}
	
	public Student updateStudent(Student student, int student_id) {
		
		Student student2 = entityManager.find(Student.class, student_id);
		if(student2 != null) {
			student2.setId(student_id);
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
			return student2;
		}
		
		return null;
	}
	
public boolean deleteStudent(int student_id) {
		
		Student student2 = entityManager.find(Student.class, student_id);
		if(student2 != null) {
			entityTransaction.begin();
			entityManager.remove(student2);
			entityTransaction.commit();
			return true;
		}
		
		return false;
	}
}
