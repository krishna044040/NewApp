<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet" type="text/css" href="basic.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=showdiv;
function showdiv(){
	var s=document.getElementById("dname");
	var t=s.innerText;
	if(t=="null"){
		var s2=document.getElementById("showOrNot");
		s2.style.display="none";
		document.getElementById("thanks").style.display="none";
	}
	document.getElementById("deleteButton").disabled= true;
	document.getElementById("deleteButton").style.color='red';
}


function enabledelete(){
	document.getElementById("deleteButton").disabled= false;
	document.getElementById("deleteButton").style.color='green';
	}

function populateData(){
	var	id=document.querySelector('input[name="id"]:checked').value;
	document.getElementById("idno").value=id;
	document.getElementById("popdata").href="populate.krs?drugId="+id;
	showupdatebutton();
}

function showupdatebutton() {
	var val =document.getElementById("drname").value;
	if(val==""){
		document.getElementById("updateForm").style.display="none";
		}else{
			document.getElementById("updateForm").style.display="block";
		}
}
</script>
</head>
<body>
<h1 id="thanks">Thank you for placing the order</h1>
<div id="showOrNot"  >
<table border="1" class="basic" >
<tr><td><font style="font-size: 30px">Drug name</font></td><td id="dname"> <%=request.getParameter("dname") %></td></tr>
<tr><td><font style="font-size: 30px">Drug price</font></td><td><%=request.getParameter("dprice") %></td></tr>
<tr><td><font style="font-size: 30px">Date of mfg.</font></td><td><%=request.getParameter("dmfg") %></td></tr>
<tr><td><font style="font-size: 30px">Date of exp.</font></td><td><%=request.getParameter("dexp") %></td></tr>
</table>
</div>
<div class="basic">
<a href="show.krs" class="button">Show all drugs</a><br>
<form action="del.krs" method="post" onchange="enabledelete();" id="formdata">
<c:forEach var="listValue" items="${values}">
				<table>
				<tr><td><li></li><td><input  type="radio" name="id" value="${listValue.getId()}" /></td>
				<td>${listValue.getId()}</td>
				<td>${listValue.getDname()}</td>
				<td>${listValue.getPrice()}</td>
				<td>${listValue.getDexp()} </td>
				<td>${listValue.getDmfg()} </td>
				</li></tr>
			</c:forEach>
			</table>
			<input id="deleteButton" class="button" type="submit" value="Delete"/>
</form>			
<a href="http://localhost:9997/Realtimeprg/ProductForm.jsp" class="button">Order more</a>			
<a  class="button" onclick="populateData();" id="popdata">Update</a><br>
<a href="#" onclick="showupdatebutton();" class="button">Hide/Show Form</a><br>

<form action="update.krs" id="updateForm">
<table class="tab" ><tr>
<td>ID</td><td><input type="text" name="idno_" id="idno" value="${Drugvalue.getId()}"/></td><td>Date Of Mfg.</td><td><input type="Date" name="dmfg_" id="dmfg" value="${Drugvalue.getDmfg()}"/></td></tr>
<tr><td>Name</td><td><input type="text" name="dname_" id="drname" value="${Drugvalue.getDname()}"/></td><td>Date Of Exp.</td><td><input type="Date" name="dexp_" id="dexp" value="${Drugvalue.getDexp()}"/></td></tr>
<tr><td>Price</td><td><input type="text" name="dprice_" id="dprice" value="${Drugvalue.getPrice()}"/></td></tr>
<tr><td>&nbsp</td><td><input  style="align-self: center;" type="submit" class="button" value="Update the value"/></td><td></td>
</tr></table>
</form>
<font color="green" size="5"> ${success}</font>
</div>
</body>
</html>