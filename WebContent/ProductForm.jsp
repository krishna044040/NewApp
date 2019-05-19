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
<div class="basic">
<h1>Krishna Drug Store</h1>
<form action="req.krs" method="post">
<table>
<tr><td>Drug name </td><td><input style="border-radius: 15px; width: 300px" type="text" name="dname"/></td></tr>
<tr><td>Price</td><td><input style="border-radius: 15px; width: 300px" type="text" name="dprice"/></td></tr>
<tr><td>Date of mfg</td><td><input style="border-radius: 15px; width: 300px" type="date" name="dmfg"/></td></tr>
<tr><td>Date of Exp</td><td><input style="border-radius: 15px; width: 300px" type="date" name="dexp"/></td></tr>
</table><br>
<input type="submit" class="button" value="Place the order"/>
</form>
</div>
<a href="http://localhost:9997/Realtimeprg/orders.jsp">Go to Orders</a>	
</body>

</html>