<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>      
<%@ page import="java.sql.Date"%>   
<%@ page import="java.lang.Long"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
    String FirstName =(String) request.getAttribute("FirstName");
	String LastName=(String) request.getAttribute("LastName");
	float comm=(float) request.getAttribute("comm");
	Date hiredate=(Date) request.getAttribute("hiredate");
	String job=(String) request.getAttribute("job");
	float salary=(float) request.getAttribute("salary");
	Long DeptId=(Long) request.getAttribute("DeptId");
	Long managerID=(Long) request.getAttribute("managerID");
	Long empId=(Long) request.getAttribute("empId");
	Long locId = (Long)request.getAttribute("locId");
%>

	<h1 style="text-align:center">All info about Mr <%=LastName %> </h1>
	
	
	
	<table>
		<tr>
			<th align="center">Employee Id</th>
			<th align= "center">First Name</th>
			<th align= "center">Last Name</th>
			<th align= "center">Commission</th>
			<th align= "center">Hire date</th>
			<th align= "center">Job</th>
			<th align= "center">Salary</th>
			<th align= "center">Department Id</th>
			<th align= "center">Manager Id</th>
			
		</tr>
		
		<tr>
			<td> <%=empId %> </td>
			<td> <%=FirstName %> </td>
			<td> <%=LastName %> </td>
			<td> <%=comm %> </td>
			<td> <%=hiredate %> </td>
			<td> <%=job %> </td>
			<td> <%=salary %> </td>
			<td> <%=DeptId %> </td>
			<td> <%=managerID %> </td>
			
		</tr>
		
		
	
		
	 </table>	


<form  method="Get" action="/locations/${locId}/departments/${deptId}">
    	<a>
 		<button name="Back">Go Back To Employees</button>
   		</a>
</form>



</body>
</html>