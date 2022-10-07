package com.tipu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tipu.dao.StudentDao;
import com.tipu.model.Student;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<a href='index.jsp'>Add New Student </a>");
		out.println("<h1>Student List</h1>");

		List<Student> list = StudentDao.getAllStudent();
		out.print("<table border='1' width='100' ");

		out.print("<tr> <th> ID </th> <th>Name</th> <th> Password </th> <th> Email </th> <th> Country</th> "
				+ "<th>Edit</th> <th>Delete</th> </tr>");
		for (Student st : list) {

			out.print("<tr> <td>"+st.getId()+"</td><td>"+st.getName()+"</td> <td>"+st.getPassword()+"</td><td>"+ st.getEmail()
			+"</td>  <td>" +st.getCountry()+"<td><a href='EditServlet?id="+st.getId()
					+"'>edit</a></td><td><a href='DeleteServlet?id="+st.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");

		out.close();

	}

}
