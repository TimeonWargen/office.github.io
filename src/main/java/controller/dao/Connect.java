package controller.dao;

import java.io.IOException;
import java.sql.*;

public class Connect {
    public Connection conn() throws IOException, SQLException {
        String URL = "jdbc:mysql://localhost:3306/office?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String USER = "root";
        String PASSWORD = "rootroot";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
    public int valueEmployees() throws SQLException, IOException {
        Connect a = new Connect();
        int val = 0;
        Connection connection = a.conn();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employees");
        while (resultSet.next()) {
            val = resultSet.getInt("id");
        }
        return val;
    }
    /*public int valueDepartments(int val) throws SQLException, IOException {
        Connect a = new Connect();
        int z = 0;
        Connection connection = a.conn();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from departments");
        while (resultSet.next()) {
            val += resultSet.getInt("id");
        }
        z = val;
        val = 0;
        return z;
    }*/
    public StringBuffer getDepartments(int i) throws IOException, SQLException {
        Connect a = new Connect();
        String s = new String();
        StringBuffer sb = new StringBuffer();
        Connection connection = a.conn();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from departments where id = '"+ i +"'");
        while (rs.next()) {
            s = (rs.getInt(1) + "  " + rs.getString("name"));
            sb.append(s);
        }
        return sb;

    }
    public String getDepartment(int i) throws IOException, SQLException {
        Connect a = new Connect();
        Connection connection = a.conn();
        String s = new String();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from departments where id = '"+ i +"'");
        while (rs.next()) {
            s = (rs.getString("name"));
        }
        return s;
    }
}
