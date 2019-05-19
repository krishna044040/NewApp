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
<h1>Welcome to Drug Store</h1>
<form action="register.krs" method="post">
<table>
<tr><td>Full Name</td><td><input style="border-radius: 15px; width: 300px" type="text" name="fname"/></td></tr><font color="red" size="5">${nameerror}</font>
<tr><td>Date Of Birth</td><td><input style="border-radius: 15px; width: 300px" type="date" name="dob"/></td></tr>
<tr><td>Username</td><td><input style="border-radius: 15px; width: 300px" type="text" name="username"/></td></tr>
<tr><td>Phone</td><td><input style="border-radius: 15px; width: 300px" type="text" name="phone"/></td></tr>
<tr><td>How did you get to know about this application?</td><td><input  type="radio" name="reason" value="friends" checked="checked"/>Friends
<input type="radio" name="reason" value="ads"/>Ads
<input type="radio" name="reason" value="online"/>Online</td></tr>
</table><br>
<input type="submit" value="Register"/><br>
<font color="green" size="8"> ${msg}</font>
</form>
<a href="http://localhost:9997/Realtimeprg/Login.jsp">Already registered?<br>Login</a>
</div>
</body>

</html>