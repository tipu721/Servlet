package com.tipu.controller;

import com.tipu.dao.StudentDao;
import com.tipu.model.Student;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event){
        ArrayList list = new ArrayList();
        Connection connection = StudentDao.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Student st = new Student();

                st.setId(resultSet.getInt(1));
                st.setName(resultSet.getString(2));
                st.setPassword(resultSet.getString(3));
                st.setEmail(resultSet.getString(4));
                st.setCountry(resultSet.getString(5));

                list.add(st);

            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //storing the ArrayList object in ServletContext
        ServletContext context = event.getServletContext();
        context.setAttribute("data", list);

    }
    public void contextDestroyed(ServletContextEvent arg0){
        System.out.println("Project Undeployed");
    }
}
