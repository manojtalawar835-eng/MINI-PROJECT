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
@WebServlet("/display")
public class DisplayEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            req.setAttribute("list", new EmployeeDAO().getAllEmployees());
            req.getRequestDispatcher("empdisplay.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}