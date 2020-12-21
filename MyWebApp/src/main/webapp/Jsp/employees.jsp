<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>  
<!DOCTYPE html>
<html>
<head>



<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
    String deptmentName=(String) request.getAttribute("DepartmentName");
	String locName=(String) request.getAttribute("locName");
%>
	
	<h1 style="text-align:center">Employees working at <%=deptmentName %> in <%=locName %></h1>
	
	<table>
		<tr style="text-align:center">
			<th style="text-align:center">Employee Id</th>
			<th style="text-align:center">First Name</th>
			<th style="text-align:center">Last Name</th>
			<th>All info about each Employee</th>
		
		</tr>
		
		
		<c:forEach items="${allEmployeesInDept}" var="emp">
        <tr style="text-align:center">
            <td style="text-align:center"><c:out value="${emp.getEmpid()}"/></td>
            <td style="text-align:center"><c:out value="${emp.getFirstname()}"/></td>
            <td style="text-align:center"><c:out value="${emp.getLastname()}"/></td>
            <td>
            	 <FORM NAME="Go To" METHOD="Get" Action="/locations/${locId}/departments/${deptId}/employees/${emp.getEmpid()}">
        			<INPUT TYPE="SUBMIT" NAME="Employeesbutton" VALUE="All info about ${emp.getLastname()}"/>
    			</FORM> 
            </td>
             
             
        </tr>
    </c:forEach>
		
	 </table>	

<form  method="Get" action="/locations/${locId}">
    	<a>
 		<button name="Back">Go Back To Departments</button>
   		</a>
</form>

<form  method="Get" action="/locations/Goback">
    	<a>
 		<button name="Back">Go Back To Locations</button>
   		</a>
</form>


</body>
</html>