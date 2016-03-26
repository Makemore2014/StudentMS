package db;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import pojo.Student;
import pojo.User;
import sun.security.provider.MD5;
import utils.Secret;

public class DBConn {
	Connection con = null;

	public Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = (Connection) DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/StudentMS?useUnicode=true&characterEncoding=utf8", "root",
						"mym0124");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	@SuppressWarnings("finally")
	public boolean registerUser(User user) {
		getCon();
		PreparedStatement psmt;
		if (user.getPassWord().length() == 0 || user.getUserName().length() == 0) {
			return false;
		} else if (user.getPassWord().length() > 20 || user.getUserName().length() > 16) {
			return false;
		} else {
			try {
				psmt = con.prepareStatement("insert into User(userName,passWord) values(?,?)");

				String passWord = Secret.getMD5(user.getPassWord().getBytes());

				psmt.setString(1, user.getUserName());
				psmt.setString(2, passWord);
				psmt.execute();
				return true;
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
				return true;
			}
		}
	}

	public boolean loginUser(User user) {
		getCon();
		ResultSet rs = null;

		System.out.println(user.getUserName());
		System.out.println(user.getPassWord());

		String passWord = Secret.getMD5(user.getPassWord().getBytes());

		boolean b = false;

		try {
			PreparedStatement psmt = con.prepareStatement("select * from User where userName = ? and passWord = ?");
			psmt.setString(1, user.getUserName());
			psmt.setString(2, passWord);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 释放资源
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}

	public boolean AddStudent(Student student) {
		getCon();
		PreparedStatement psmt = null;
		try {

			if (student.getNumber().length() > 10 || student.getName().length() > 20 || student.getSex().length() > 20
					|| student.getAge().length() > 10 || student.getAddress().length() > 20) {
				return false;
			}

			else if (student.getNumber().length() == 0 || student.getName().length() == 0
					|| student.getSex().length() == 0 || student.getAge().length() == 0
					|| student.getAddress().length() == 0) {
				return false;
			} else {

				psmt = con.prepareStatement("insert into Student(number,name,sex,age,address) values(?,?,?,?,?)");
				psmt.setString(1, student.getNumber());
				psmt.setString(2, student.getName());
				psmt.setString(3, student.getSex());
				psmt.setString(4, student.getAge());
				psmt.setString(5, student.getAddress());

				psmt.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generatvalueOf(data, offset, count)ed catch block
				e.printStackTrace();
			}
		}
		return true;
	}
}
