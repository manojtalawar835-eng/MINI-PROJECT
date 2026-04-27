package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class EmployeeDAO {

    private String url = "jdbc:mysql://localhost:3306/emp_db";
    private String user = "root";
    private String pass = "password";

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

    public void addEmployee(Employee e) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO Employee VALUES(?,?,?,?,?)");

        ps.setInt(1, e.getEmpno());
        ps.setString(2, e.getEmpName());
        ps.setDate(3, e.getDoj());
        ps.setString(4, e.getGender());
        ps.setDouble(5, e.getSalary());

        ps.executeUpdate();
        con.close();
    }

    public void updateEmployee(Employee e) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE Employee SET EmpName=?, DoJ=?, Gender=?, Bsalary=? WHERE Empno=?");

        ps.setString(1, e.getEmpName());
        ps.setDate(2, e.getDoj());
        ps.setString(3, e.getGender());
        ps.setDouble(4, e.getSalary());
        ps.setInt(5, e.getEmpno());

        ps.executeUpdate();
        con.close();
    }

    public void deleteEmployee(int empno) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM Employee WHERE Empno=?");

        ps.setInt(1, empno);
        ps.executeUpdate();
        con.close();
    }

    public List<Employee> getAllEmployees() throws Exception {
        List<Employee> list = new ArrayList<>();
        Connection con = getConnection();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Employee");

        while (rs.next()) {
            Employee e = new Employee();
            e.setEmpno(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setDoj(rs.getDate(3));
            e.setGender(rs.getString(4));
            e.setSalary(rs.getDouble(5));
            list.add(e);
        }
        con.close();
        return list;
    }
}