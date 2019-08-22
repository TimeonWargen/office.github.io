<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="controller.dao.Connect" %>
<%@ page import="javax.xml.validation.Validator" %>
<%@ page import="javax.xml.transform.Source" %>
<%@ page import="javax.xml.transform.Result" %>
<%@ page import="org.xml.sax.SAXException" %>
<%@ page import="java.io.IOException" %>
<%@ page import="org.xml.sax.ErrorHandler" %>
<%@ page import="org.w3c.dom.ls.LSResourceResolver" %><%--
  Created by IntelliJ IDEA.
  User: artke
  Date: 16.08.2019
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Departments</title>
</head>
<body>
<h1>Departments maker</h1>
<form action = "createdepartmentservlet" method = "GET">
    <table border = "0">
        <tr>
            <td><b>Name of department</b></td>
            <td><input type = "text" name = "New department" required maxlength="20"
                       value = "" size = "50"/></td>
        </tr>
        <tr>
            <td colspan = "2"><input type = "submit" value = "Create"/></td>
        </tr>
    </table>
</form>
<form action = "deletedepartmentsservlet" method = "GET">
    <table border = "0">
        <tr>
            <td><b>id of department to delete</b></td>
            <td><input type = "number" name = "deletedepartment" required
                       value = "" size = "50"/></td>
        </tr>
        <tr>
            <td colspan = "2"><input type = "submit" value = "Delete"/></td>
        </tr>
    </table>
</form>
<form action = "updatedepartmentsservlet" method = "GET">
    <table border = "0">
        <tr>
            <td><b>id of department to update</b></td>
            <td><input type = "number" name = "updatedepartment" required
                       value = "" size = "50"/></td>
        </tr>
        <tr>
            <td><b>New name of department to update</b></td>
            <td><input type = "text" name = "newupdateddepartment" required maxlength="20"
                       value = "" size = "50"/></td>
        </tr>
        <tr>
            <td colspan = "2"><input type = "submit" value = "Update"/></td>
        </tr>
    </table>
</form>
    <form action = "departmentlist" method = "GET">
        <table border = "0">
            <tr>
                <td><b>id of department to delete</b></td>
                <td><input type = "text" name = "departmentlist" required
                           value = "" size = "50"/></td>
            </tr>
            <tr>
                <td colspan = "2"><input type = "submit" value = "List"/></td>
            </tr>
        </table>
    </form>

<div>
    <button onclick="location.href='/Super_war_exploded/tables'"> Main page </button>
    <button onclick="location.href='/Super_war_exploded/departments'"> Departments </button>
    <button onclick="location.href='/Super_war_exploded/employees'"> Employees </button>
    <button onclick="location.href='/Super_war_exploded/employees/createemployees'"> Create Employees</button>
</div>
</body>
</html>
