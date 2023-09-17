package com.tipu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        String userName = req.getParameter("userName");
        //System.out.println(userName);
        String password = req.getParameter("userPass");

        if(userName.equals("tipu721")){

         HttpSession httpSession = req.getSession();
            httpSession.setAttribute("tipu",userName );

            req.getRequestDispatcher("wellcome.jsp").forward(req,resp);
//            resp.sendRedirect("wellcome.jsp");

        }
        else{
            resp.sendRedirect("index.jsp");
        }


    }
}
