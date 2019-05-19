<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="basic.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="basic" align="center">
<form action="login.krs" method="post">
<table>
<tr><td>User Name</td><td><input type="text" name="uname"/></td></tr>
<tr><td>Password</td><td><input type="text" name="pass"/></td></tr>
<tr><td><input type="submit" value="Login"></td></tr>
</table>
</form>
<font color="green"> ${sucessmsg}</font>
<font color="red"> ${errormsg}</font>
<a href="http://localhost:9997/Realtimeprg/Register.jsp">Not Registered?<br>Register</a>
</div>
</body>
</html>