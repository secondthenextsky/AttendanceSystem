package com.attendance.dao;

import java.util.List;

import com.attendance.bean.Student;

public interface StudentDao {
	public void add(Student student);
	public void delete(int id);
	public void update(Student student);
	public Student getById(int id);
	public List<Student> getStudentsByTeacher(int teacherId,String date);
	public void addRecord(int studentId, String date, int status);
	public void updateRecord(int studentId, String date, int status);
	/**
	 * 查询某学生在某天是否已经考勤过
	 * @param studentId
	 * @param date
	 * @return
	 */
	public boolean isRecorded(int studentId, String date);
}
