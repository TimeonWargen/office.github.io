package controller.processor.impl;

import controller.dao.Connect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;

public class CreateEmployeeServlet extends javax.servlet.http.HttpServlet {
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
        String value = (request.getParameter("New-employee"));
        Integer value2 = Integer.valueOf((request.getParameter("New-employee-age")));
        String value3 = request.getParameter("New-employee-date");
        String value4 = (request.getParameter("New-employee-email"));
        String value5 = (request.getParameter("New-employee-department"));
        int val = 0, b;
        b = a.valueEmployees();
        String c;
            for (int i = 0; i <= b; i++) {
                c = a.getDepartment(i);
                if (value5.equals(c)) {
                    statement.executeUpdate("insert into employees (name , employeeAge, employeeDate, employeeEmail, department)values('" + value + "','" + value2 + "', '" + value3 + "', '" + value4 + "', '" + value5 + "')");
                    response.sendRedirect("/Super_war_exploded/employees");
                }
                else
                    val += 1;
                if (val == b + 1)
                    out.println("Department " + value5 + " does not exist ");
            }
    }
}