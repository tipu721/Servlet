package com.tipu.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tipu.model.Student;

public class StudentDao {

	public static Connection getConnection() {

		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_crud", "root", "root");

		}

		catch (Exception message) {

			System.out.println(message);
		}

		return con;

	}

	public static int save(Student st) {

		int status = 0;

		try {

			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into Student(name,password,email,country) values (?,?,?,?)");

			ps.setString(1, st.getName());
			ps.setString(2, st.getPassword());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getCountry());

			status = ps.executeUpdate();
		}

		catch (Exception ex) {

			ex.printStackTrace();
		}

		return status;
	}

	public static List<Student> getAllStudent() {

		List<Student> list = new ArrayList<Student>();

		try {

			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Student");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Student st = new Student();

				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setPassword(rs.getString(3));
				st.setEmail(rs.getString(4));
				st.setCountry(rs.getString(5));

				list.add(st);

			}

			con.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static Student getStudentById(int id) {

		Student st = new Student();

		try {

			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Student where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setPassword(rs.getString(3));
				st.setEmail(rs.getString(4));
				st.setCountry(rs.getString(5));

			}
			con.close();
		}

		catch (Exception ex) {

			ex.printStackTrace();

		}

		return st;

	}

	public static int update(Student st) {
		int status = 0;
		try {
			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update Student set name=?,password=?,email=?,country=? where id=?");
			ps.setString(1, st.getName());
			ps.setString(2, st.getPassword());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getCountry());
			ps.setInt(5, st.getId());

			status = ps.executeUpdate();

			con.close();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {

		int status = 0;
		try {
			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from Student where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}

}
