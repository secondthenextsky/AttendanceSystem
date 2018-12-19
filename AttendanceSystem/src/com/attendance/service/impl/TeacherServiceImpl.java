package com.attendance.service.impl;

import com.attendance.bean.Teacher;
import com.attendance.dao.TeacherDao;
import com.attendance.dao.impl.TeacherDaoImpl;
import com.attendance.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	private TeacherDao teacherDao = new TeacherDaoImpl();
	
	@Override
	public void add(Teacher teacher) {
		teacherDao.add(teacher);
	}

	@Override
	public void delete(int id) {
		teacherDao.delete(id);
	}

	@Override
	public void update(Teacher teacher) {
		teacherDao.update(teacher);
	}

	@Override
	public Teacher getById(int id) {
		return teacherDao.getById(id);
	}

	@Override
	public Teacher getByNumberAndPassword(String number, String password) {
		return teacherDao.getByNumberAndPassword(number,password);
	}


}
