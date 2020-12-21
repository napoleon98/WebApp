<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="text-align:center"> Web-Services Interface </h2>

		<form id="forma" method="Post" action="webServicesInterface">
				
				<label for="insert" >Insert your request:</label>
    			<input type="text" id="request" name="request">


		</form>
		
		<%
    String Xml=(String) request.getAttribute("Xml");
	if (Xml!=null) {
	%>
	<h3>API call execution result in XML</h3>
	<textarea  rows="25" cols="45">
	<c:out value="${Xml}" />
	</textarea>

	<%  
	}
	%>
		
		

</body>
</html>