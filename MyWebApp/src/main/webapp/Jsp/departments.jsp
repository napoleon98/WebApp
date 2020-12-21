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
    String locName=(String) request.getAttribute("locName");

%>
  <h1 style="text-align:center">Departments in <%=locName %></h1>
  
  
  
  <table>
	<tr style="text-align:center">
		<th style="text-align:center">Department Id</th>
		<th style="text-align:center">Department's Name</th>
		<th style="text-align:center">Department's LocId</th>
		<th style="text-align:center">Employees Working in each Department</th>
		
	</tr>
    <c:forEach items="${alldeptsWithLocId}" var="dept">
        <tr style="text-align:center">
            <td style="text-align:center"><c:out value="${dept.getDeptId()}"/></td>
            <td style="text-align:center"><c:out value="${dept.getDname()}"/></td>
            <td style="text-align:center"><c:out value="${dept.getLocationId()}"/></td>
            <td>
            	 <FORM NAME="Go To" METHOD="Get" Action="/locations/${dept.getLocationId()}/departments/${dept.getDeptId()}">
        			<INPUT TYPE="SUBMIT" NAME="Departmentsbutton" VALUE="Employees in ${dept.getDname()}"/>
    			</FORM> 
            </td>
             
             
        </tr>
    </c:forEach>
 </table>
  
  <form method="Get" action="Goback">
    <a>
 		<button name="Back">Go Back to Locations</button>
   </a>
</form>
    
</body>
</html>