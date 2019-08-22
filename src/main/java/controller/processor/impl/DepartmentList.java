package controller.processor.impl;

import controller.dao.Connect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentList extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            this.process(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            this.process(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        response.setStatus(200);
        Connect a = new Connect();
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        Connection connection = a.conn();
        Statement statement = connection.createStatement();
        String  value = (request.getParameter("departmentlist"));
        ResultSet rs = statement.executeQuery("select * from employees where department = '" + value +"'");
        while (rs.next()){
            out.println(rs.getInt(1) + "  " + rs.getString("name") + " " + rs.getInt("employeeAge") + " " + rs.getDate("employeeDate") + " " + rs.getString("employeeEmail") + " " + rs.getString("department"));
        }
    }
}
