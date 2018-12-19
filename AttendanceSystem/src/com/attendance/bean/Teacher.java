package com.attendance.bean;
/**
 * 班主任
 *
 */
public class Teacher {
	private int id;
	private String name;
	private String number;
	private String password;
	private String gender;
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
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", number=" + number + ", password=" + password + ", gender="
				+ gender + "]";
	}
}
