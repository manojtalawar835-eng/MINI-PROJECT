package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import com.dao.EmployeeDAO;
import com.model.Employee;

import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            int id = Integer.parseInt(req.getParameter("empno"));
            new EmployeeDAO().deleteEmployee(id);
            res.sendRedirect("index.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}