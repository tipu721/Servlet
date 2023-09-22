package com.tipu.controller;


import com.tipu.dao.StudentDao;
import com.tipu.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.StartDocument;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Pagination")
public class Pagination extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(serialVersionUID);
        String spageid = req.getParameter("page");

        Integer pageid = Integer.parseInt(spageid);
        Integer total = 5;
        if(pageid != 1){
            pageid = pageid - 1;
            pageid = pageid * total + 1;
        }
        try {
            List<Student>studentList = StudentDao.getRecords(total, pageid);

            printWriter.println("<h1>Page No: " +spageid+ "</h1>");

            printWriter.print("<table border='1' width='100' ");

            printWriter.print("<tr> <th> ID </th> <th>Name</th> <th> Password </th> <th> Email </th> <th> Country</th> "
                    + "<th>Edit</th> <th>Delete</th> </tr>");
            for (Student st : studentList) {

                printWriter.print("<tr> <td>"+st.getId()+"</td><td>"+st.getName()+"</td> <td>"+st.getPassword()+"</td><td>"+ st.getEmail()
                        +"</td>  <td>" +st.getCountry()+"<td><a href='EditServlet?id="+st.getId()
                        +"'>edit</a></td><td><a href='DeleteServlet?id="+st.getId()+"'>delete</a></td></tr>");
            }
            printWriter.print("</table>");

            printWriter.close();




    }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
