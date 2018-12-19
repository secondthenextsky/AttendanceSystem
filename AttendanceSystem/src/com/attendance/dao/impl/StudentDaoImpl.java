package com.attendance.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.attendance.bean.Student;
import com.attendance.dao.StudentDao;
import com.attendance.util.MyDatabaseUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void add(Student student) {
		String sql = "insert into student(name,password,number,gender,teacherId) value(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, student.getName());
			pst.setString(2, student.getPassword());
			pst.setString(3, student.getNumber());
			pst.setString(4, student.getGender());
			pst.setInt(5, student.getTeacherId());
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
		String sql = "delete from student where id=?";
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
	public void update(Student student) {
		String sql = "update student set name=?,password=?,number=?,teacherId=?,gender=? where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, student.getName());
			pst.setString(2, student.getPassword());
			pst.setString(3, student.getNumber());
			pst.setString(4, student.getGender());
			pst.setInt(5, student.getTeacherId());
			pst.setInt(6, student.getId());
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
	public Student getById(int id) {
		String sql = "select * from student where id=?";
		Student student = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				student = new Student();
				student.setId(id);
				student.setName(rs.getString("name"));
				student.setNumber(rs.getString("number"));
				student.setPassword(rs.getString("password"));
				student.setTeacherId(rs.getInt("teacherId"));
				student.setGender(rs.getString("gender"));
				return student;
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
		return student;
	}

	
	@Override
	public List<Student> getStudentsByTeacher(int teacherId,String date) {
		List<Student> students = new ArrayList<>();
//		String sql = "select s.*,r.status from student s left join record r on s.teacherId=? and r.date=? and s.id=r.studentId";
		String sql = "select s.*,r.status from student s left join record r on s.teacherId=? and  s.id=r.studentId order by s.id";
		Student student = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, teacherId);
//			pst.setString(2, date);
			rs = pst.executeQuery();
			while(rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setNumber(rs.getString("number"));
				student.setPassword(rs.getString("password"));
				student.setTeacherId(rs.getInt("teacherId"));
				student.setGender(rs.getString("gender"));
				student.setStatus(rs.getInt("status"));
				students.add(student);
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
		return students;
	}

	@Override
	public boolean isRecorded(int studentId, String date) {
		String sql = "select * from record r where r.studentId=? and r.date=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, studentId);
			pst.setString(2, date);
			rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
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
	}

	
	@Override
	public void addRecord(int studentId, String date, int status) {
		String sql = "insert into record(studentId,date,status) value(?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, studentId);
			pst.setString(2, date);
			pst.setInt(3, status);
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
	public void updateRecord(int studentId, String date, int status) {
		String sql = "update record set status=? where studentId=? and date=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, status);
			pst.setInt(2, studentId);
			pst.setString(3, date);
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
	
}
