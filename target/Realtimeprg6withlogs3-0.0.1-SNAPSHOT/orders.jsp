<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Thank you for placing the order</h1>
<table border="1">
<tr><td><font style="font-size: 30px">Drug name</font></td><td> <%=request.getParameter("dname") %></td></tr>
<tr><td><font style="font-size: 30px">Drug price</font></td><td><%=request.getParameter("dprice") %></td></tr>
<tr><td><font style="font-size: 30px">Date of mfg.</font></td><td><%=request.getParameter("dmfg") %></td></tr>
<tr><td><font style="font-size: 30px">Date of exp.</font></td><td><%=request.getParameter("dexp") %></td></tr>
</table>

<a href="show.krs">Show all data</a><br>
<c:forEach var="listValue" items="${values}">
				<li>${listValue}</li>
			</c:forEach>
<a href="delete.krs">Delete</a><br>


</body>
</html>