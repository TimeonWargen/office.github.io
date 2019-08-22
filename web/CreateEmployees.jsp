<%@ page import="java.util.List" %>
<%@ page import="controller.dao.Connect" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: artke
  Date: 16.08.2019
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employees</title>
</head>
<body>
<form action = "createemployeeservlet" method = "GET">
    <table border = "0">
        <tr>
            <td><b>Name of employee: </b></td>
            <td><input type = "text" name = "New-employee" maxlength="20" required
                    value = "" size = "50"/></td>
        </tr>
        <tr>
            <td><b>Age of employee: </b></td>
            <td><input type = "number" name = "New-employee-age" min="18" max="120" required
                       value = "" size = "10"/></td>
        </tr>
        <tr>
            <td><b>Date of employee: </b></td>
            <td><input type = "date" name = "New-employee-date" required
                       value = "" size = "10"/></td>
        </tr>
        <tr>
            <td><b>E-mail: </b></td>
            <td><input type = "email" name = "New-employee-email" maxlength="64" required
                       value = "" size = "64"/></td>
        </tr>
        <tr>
            <td><b>Department: </b></td>
            <td><input type = "text" name = "New-employee-department" required
                       value = "" size = "50"/></td>
        </tr>
        <tr>
            <td colspan = "2"><input type = "submit" value = "Create"/></td>
        </tr>
    </table>
</form>
<form action = "deleteemployeesservlet" method = "GET">
    <table border = "0">
        <tr>
            <td><b>id of employee to delete</b></td>
            <td><input type = "number" name = "deleteemployee" required
                       value = "" size = "50"/></td>
        </tr>
        <tr>
            <td colspan = "2"><input type = "submit" value = "Delete"/></td>
        </tr>
    </table>
</form>
<form action = "updateemployeesservlet" method = "GET">
    <table border = "0">
        <tr>
            <td><b>Select id for update: </b></td>
            <td><input type = "number" name = "Updaterforemployee" required
                       value = "" size = "50"/></td>
        </tr>
        <tr>
            <td><b>New name of employee: </b></td>
            <td><input type = "text" name = "Updatedemployeename" required maxlength="20"
                       value = "" size = "50"/></td>
        </tr>
        <tr>
            <td><b>New age of employee: </b></td>
            <td><input type = "number" name = "Updatedemployeeage" required min="18" max="120"
                       value = "" size = "10"/></td>
        </tr>
        <tr>
            <td><b>New date of employee: </b></td>
            <td><input type = "date" name = "Updatedemployeedate" required
                       value = "" size = "10"/></td>
        </tr>
        <tr>
            <td><b>New e-mail: </b></td>
            <td><input type = "email" name = "Updatedemployeeemail" required maxlength="64"
                       value = "" size = "64"/></td>
        </tr>
        <tr>
            <td><b>New department: </b></td>
            <td><input type = "text" name = "Updatedemployeedepartment" required
                       value = "" size = "50"/></td>
        </tr>
        <tr>
            <td colspan = "2"><input type = "submit" value = "Update"/></td>
        </tr>
    </table>
</form>
<button onclick="location.href='/Super_war_exploded/tables'"> Main page </button>
<button onclick="location.href='/Super_war_exploded/departments'"> Departments </button>
<button onclick="location.href='/Super_war_exploded/departments/createdepartments'"> Create Departments </button>
<button onclick="location.href='/Super_war_exploded/employees'"> Employees </button>
</body>
</html>
