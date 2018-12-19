package com.attendance.dao;

import java.util.List;

import com.attendance.bean.Student;

public interface StudentDao {
	public void add(Student student);
	public void delete(int id);
	public void update(Student student);
	public Student getById(int id);
	public List<Student> getStudentsByTeacher(int teacherId);
}
