<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Departments' Locations</title>


</head>
<body>
		<h1 align="center" >Departments' Locations</h1>
		
		
		
		
	<table>
		<tr>
			<th align="center">Location Id  </th>
			<th align="center">Location Name  </th>
			<th align="center">Departments in each Location</th>
	
		</tr>
      <c:forEach items="${LocationsList}" var="loc">
        <tr>
            <td align="center"><c:out value="${loc.getLocid()}"/></td>
            <td align="center"><c:out value="${loc.getLocname()}"/></td>
            
            
            <td>
            	 <FORM NAME="Go To" METHOD="Get" Action="/locations/${loc.getLocid()}">
        			<INPUT TYPE="SUBMIT" NAME="locationsbutton" VALUE="Departments in ${loc.getLocname()}"/>
    			</FORM> 
            </td>
           
        </tr>
     </c:forEach>
   </table>
		
		
		
		
</body>
</html>