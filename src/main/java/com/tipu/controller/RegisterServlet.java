package com.tipu.controller;

import com.tipu.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        String userName = req.getParameter("userName");
        String userPass = req.getParameter("userPass");
        String userEmail =req.getParameter("userEmail");
        String userCountry =req.getParameter("userCountry");

        Connection connection = StudentDao.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into registeruser values(?,?,?,?)");

            ps.setString(1, userName);
            ps.setString(2, userPass);
            ps.setString(3, userEmail);
            ps.setString(4, userCountry);

            int f = ps.executeUpdate();
            if(f > 0){
                pw.println("Successfully Registered");
            }



        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
