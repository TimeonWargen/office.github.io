package controller.processor.impl;

import controller.dao.Connect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Set;

public class CreateDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            this.process(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        Enumeration en = request.getParameterNames();
        String name = (String) en.nextElement();
        String value =(request.getParameter(name));
        try {
                    statement.executeUpdate("insert into departments (name)values('" + value + "')");
                    response.sendRedirect("/Super_war_exploded/departments");
                }catch (Exception e){
                    out.println(name + " wasn't create");
                }
            }

    }
