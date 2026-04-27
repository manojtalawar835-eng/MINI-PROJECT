package com.servlet;
import javax.servlet.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;

import java.sql.Date;
import java.util.List;
@WebServlet("/reportCriteria")
public class ReportCriteriaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setAttribute("type", req.getParameter("type"));
        req.setAttribute("value", req.getParameter("value"));

        req.getRequestDispatcher("report_result.jsp").forward(req, res);
    }
}