package com.tipu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tipu.dao.StudentDao;
import com.tipu.model.Student;

@WebServlet("/SaveServlet")

public class SaveServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		Student st = new Student();

		st.setName(name);
		st.setPassword(password);
		st.setEmail(email);
		st.setCountry(country);

		int status = StudentDao.save(st);

		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		
		else{
			
			out.println("Sorry! unable to save Record");
			
		}
		
		out.close();

	}

}
