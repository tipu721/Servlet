package com.tipu.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tipu.dao.StudentDao;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDao.delete(id);
		response.sendRedirect("ViewServlet");
		
		
	}
	
	

}
