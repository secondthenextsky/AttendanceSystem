package com.attendance.bean;
/**
 * 学生
 *
 */
public class Student {
	private int id;
	private String name;
	private String number;
	private String password;
	private String gender;
	private int teacherId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", number=" + number + ", password=" + password + ", gender="
				+ gender + ", teacherId=" + teacherId + "]";
	}
	
}
