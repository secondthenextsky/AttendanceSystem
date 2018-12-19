package com.attendance.service.impl;

import java.util.List;

import com.attendance.bean.Student;
import com.attendance.dao.StudentDao;
import com.attendance.dao.impl.StudentDaoImpl;
import com.attendance.service.StudentService;

public class StudentServiceImpl implements StudentService{

	private StudentDao StudentDao = new StudentDaoImpl();
	
	@Override
	public void add(Student student) {
		StudentDao.add(student);
	}

	@Override
	public void delete(int id) {
		StudentDao.delete(id);
	}

	@Override
	public void update(Student student) {
		StudentDao.update(student);
	}

	@Override
	public Student getById(int id) {
		return StudentDao.getById(id);
	}

	@Override
	public List<Student> getStudentsByTeacher(int teacherId) {
		return StudentDao.getStudentsByTeacher(teacherId);
	}

}
