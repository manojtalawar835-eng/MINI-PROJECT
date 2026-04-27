package com.servlet;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;

import java.sql.Date;
import java.util.List;
@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            Employee e = new Employee();
            e.setEmpno(Integer.parseInt(req.getParameter("empno")));
            e.setEmpName(req.getParameter("name"));
            e.setDoj(Date.valueOf(req.getParameter("doj")));
            e.setGender(req.getParameter("gender"));
            e.setSalary(Double.parseDouble(req.getParameter("salary")));

            new EmployeeDAO().updateEmployee(e);
            res.sendRedirect("index.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}