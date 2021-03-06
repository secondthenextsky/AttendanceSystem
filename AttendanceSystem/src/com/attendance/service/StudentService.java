package com.attendance.service;

import java.util.Date;
import java.util.List;

import com.attendance.bean.Student;

public interface StudentService {
	public void add(Student student);
	public void delete(int id);
	public void update(Student student);
	public Student getById(int id);
	public List<Student> getStudentsByTeacher(int teacherId,Date date);
	void record(int studentId, Date date, int status);
}
