package com.tipu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tipu.dao.StudentDao;
import com.tipu.model.Student;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();  
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Student st = new Student();
		
		st.setId(id);
		st.setName(name);
		st.setPassword(password);
		st.setEmail(email);
		st.setCountry(country);
		
		int status = StudentDao.update(st);
		if(status > 0) {
			response.sendRedirect("ViewServlet");
		}
		else {
			out.println("Sorry! Unable to update Record");
		}
		
		out.close();
	}

}
