package com.tipu.controller;

import com.tipu.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        Connection connection = StudentDao.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "select * from student where name = ?");


            preparedStatement.setString(1, "Sultan");

            printWriter.print("<table width=50% border=1>");
            printWriter.print("<caption>Student:</caption>");

            ResultSet resultSet = preparedStatement.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            printWriter.print("<tr>");
            for(int i=1; i<=columnCount; i++){
                printWriter.print("<th>"+resultSetMetaData.getColumnName(i)+"</th>");

            }
            printWriter.print("</tr>");

            while (resultSet.next()){
                printWriter.print("<tr><td>"+resultSet.getInt(1)+"</td>");
                printWriter.print("<td>"+resultSet.getString(2)+"</td>");
                printWriter.print("<td>"+resultSet.getString(3)+"</td>");
                printWriter.print("<td>"+resultSet.getString(4)+"</td>");
                printWriter.print("<td>"+resultSet.getString(5)+"</td>");
            }
            printWriter.println("</tr>");




        }

        catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
