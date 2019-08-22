<%@ page import="java.io.PrintWriter" %>
<%@ page import="controller.dao.Connect" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: artke
  Date: 16.08.2019
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Departmens</title>
</head>
<body>
    <%
    PrintWriter pw = response.getWriter();
    Connect a = new Connect();
        Connection connection = a.conn();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from departments");
        while (rs.next()) {
            pw.println("<p>");
            pw.println(rs.getInt(1) + "  " + rs.getString("name"));
            pw.println("</p>");
        }
    %>


    <button onclick="location.href='/Super_war_exploded/tables'"> Main page </button>
    <button onclick="location.href='/Super_war_exploded/departments/createdepartments'"> Create Departments </button>
    <button onclick="location.href='/Super_war_exploded/employees'"> Employees </button>
    <button onclick="location.href='/Super_war_exploded/employees/createemployees'"> Create Employees</button>
</body>
</html>
