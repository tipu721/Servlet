package com.tipu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/downloadfile")
public class DowloadFile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpg");
        PrintWriter printWriter = resp.getWriter();
        String filename = "300x300.jpg";
        String filepath = "G:/new/";

        resp.setHeader("Content-Disposition","attachment; filename=\""+filename+"\"");
        FileInputStream fileInputStream = new FileInputStream(filepath+filename);
        int i;
        while(true){
            i = fileInputStream.read();
            if(i != -1){
                printWriter.println(i);
            }
            else
                break;


        }
        fileInputStream.close();
        printWriter.close();
    }
}
