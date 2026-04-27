<%@ page import="java.util.*,com.model.Employee" %>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Salary</th></tr>

<%
List<Employee> list = (List<Employee>)request.getAttribute("list");
for(Employee e : list){
%>
<tr>
<td><%=e.getEmpno()%></td>
<td><%=e.getEmpName()%></td>
<td><%=e.getSalary()%></td>
</tr>
<% } %>
</table>