package com.attendance.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.attendance.bean.Teacher;
import com.attendance.dao.TeacherDao;
import com.attendance.util.MyDatabaseUtil;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public void add(Teacher teacher) {
		String sql = "insert into teacher(name,password,number,gender) value(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, teacher.getName());
			pst.setString(2, teacher.getPassword());
			pst.setString(3, teacher.getNumber());
			pst.setString(4, teacher.getGender());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from teacher where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(Teacher teacher) {
		String sql = "update teacher set name=?,password=?,number=?,gender=? where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, teacher.getName());
			pst.setString(2, teacher.getPassword());
			pst.setString(3, teacher.getNumber());
			pst.setString(4, teacher.getGender());
			pst.setInt(5, teacher.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Teacher getById(int id) {
		String sql = "select * from teacher where id=?";
		Teacher teacher = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				teacher = new Teacher();
				teacher.setId(id);
				teacher.setName(rs.getString("name"));
				teacher.setNumber(rs.getString("number"));
				teacher.setPassword(rs.getString("password"));
				teacher.setGender(rs.getString("gender"));
				return teacher;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return teacher;
	}

	@Override
	public Teacher getByNumberAndPassword(String number, String password) {
		String sql = "select * from teacher where number=? and password=?";
		Teacher teacher = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, number);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setNumber(rs.getString("number"));
				teacher.setPassword(rs.getString("password"));
				teacher.setGender(rs.getString("gender"));
				return teacher;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return teacher;
	}

}
