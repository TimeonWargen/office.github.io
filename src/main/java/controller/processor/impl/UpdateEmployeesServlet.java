package controller.processor.impl;

import controller.dao.Connect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class UpdateEmployeesServlet extends javax.servlet.http.HttpServlet{
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
        Integer valid = Integer.valueOf((request.getParameter("Updaterforemployee")));
        String value = request.getParameter("Updatedemployeename");
        Integer value2 = Integer.valueOf((request.getParameter("Updatedemployeeage")));
        String value3 = request.getParameter("Updatedemployeedate");
        String value4 = (request.getParameter("Updatedemployeeemail"));
        String value5 = (request.getParameter("Updatedemployeedepartment"));
        int val = 0;
        int b = a.valueEmployees();
        statement.executeUpdate("update employees set name = '" + value + "' where id = '" + valid + "'");
        statement.executeUpdate("update employees set employeeAge = '" + value2 + "' where id = '" + valid + "'");
        statement.executeUpdate("update employees set employeeDate = '" + value3 + "' where id = '" + valid + "'");
        statement.executeUpdate("update employees set employeeEmail = '" + value4 + "' where id = '" + valid + "'");
        String c;
        for (int i = 0; i <= b; i++) {
            c = a.getDepartment(i);
            if (value5.equals(c)) {
                statement.executeUpdate("update employees set department = '" + value5 + "' where id = '" + valid + "'");
                response.sendRedirect("/Super_war_exploded/employees");
            }
            else
                val += 1;
            if (val == b + 1)
                out.println("Department " + value5 + " does not exist ");
        }
    }
}
