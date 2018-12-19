package com.attendance.dao;

import com.attendance.bean.Teacher;

public interface TeacherDao {
	public void add(Teacher teacher);
	public void delete(int id);
	public void update(Teacher teacher);
	public Teacher getById(int id);
	public Teacher getByNumberAndPassword(String number, String password);
}
