package com.tipu.controller;

import com.tipu.model.Student;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class MyServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        long before = System.currentTimeMillis();
        ServletContext context = getServletContext();
        List list = (List)context.getAttribute("data");

        Iterator itr = list.iterator();
        while(itr.hasNext()){
            Student student =(Student) itr.next();
            printWriter.println("<br>"+ student.getName()+" "+student.getEmail());
        }
        long after = System.currentTimeMillis();

        printWriter.println("<br>total time :"+(after-before));
        printWriter.close();

    }
}
