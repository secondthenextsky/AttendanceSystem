package com.attendance.service.impl;

import java.util.Date;
import java.util.List;

import com.attendance.bean.Student;
import com.attendance.dao.StudentDao;
import com.attendance.dao.impl.StudentDaoImpl;
import com.attendance.service.StudentService;

public class StudentServiceImpl implements StudentService{

	private StudentDao studentDao = new StudentDaoImpl();
	
	@Override
	public void add(Student student) {
		studentDao.add(student);
	}

	@Override
	public void delete(int id) {
		studentDao.delete(id);
	}

	@Override
	public void update(Student student) {
		studentDao.update(student);
	}

	@Override
	public Student getById(int id) {
		return studentDao.getById(id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Student> getStudentsByTeacher(int teacherId,Date date) {
		String dateString = (date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate();
		return studentDao.getStudentsByTeacher(teacherId,dateString);
	}
	
	@Override
	public void record(int studentId, Date date, int status) {
		String dateString = (date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate();
		if(studentDao.isRecorded(studentId, dateString)) {
			studentDao.updateRecord(studentId, dateString, status);
		}else {
			studentDao.addRecord(studentId, dateString, status);
		}
	}

}
