<%@ page import="java.sql.*" %>

<%
String type = (String)request.getAttribute("type");
String value = (String)request.getAttribute("value");

Class.forName("com.mysql.cj.jdbc.Driver"); 

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/empdb?useSSL=false&serverTimezone=UTC",
"root",
"password"
);

Statement st = con.createStatement();
%>