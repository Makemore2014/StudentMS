package Impl;

import db.DBConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;

import pojo.Student;

public class ImplStudent {
	DBConn db = new DBConn();

	public boolean AddStudent(Student student) {
		return db.AddStudent(student);
	}

	public ArrayList<Student> queryStudent(String name) {
		ArrayList<Student> students = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		DBConn conns = new DBConn();
		con = conns.getCon();
		try {
			if (name.equals("")) {
				pre = con.prepareStatement("select * from Student ");
			} else {
				pre = con.prepareStatement("select * from Student where name =?");
				pre.setString(1, name);
			}
			rs = pre.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setNumber(rs.getString("number"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setAge(rs.getString("age"));
				student.setAddress(rs.getString("address"));
				student.setId(rs.getString("id"));
				students.add(student);

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}

	public ArrayList<Student> queryStudent() {
		ArrayList<Student> students = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		DBConn conns = new DBConn();
		con = conns.getCon();
		try {

			pre = con.prepareStatement("select * from Student ");

			rs = pre.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setNumber(rs.getString("number"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setAge(rs.getString("age"));
				student.setAddress(rs.getString("address"));
				student.setId(rs.getString("id"));
				students.add(student);

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}

	public boolean updatestudent(Student student) {
		
		boolean rt = false ;
		
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		DBConn conns = new DBConn();
		con = conns.getCon();
		try {
			pre = con.prepareStatement(
					"update Student set number = ?,name = ?,sex = ?,age = ?,address = ? where id = ?");
			pre.setString(1, student.getNumber());
			pre.setString(2, student.getName());
			pre.setString(3, student.getSex());
			pre.setString(4, student.getAge());
			pre.setString(5, student.getAddress());
			pre.setString(6, student.getId());
			
			System.out.println(student.getId());
			
			pre.execute();
			
			rt = true ;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rt;
	}

	public ArrayList<Student> deleteStudent(String id) {

		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getCon();
		try {
			pre = con.prepareStatement("delete from Student where id = ?");
			pre.setString(1, id);
			pre.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return queryStudent();

	}
}
