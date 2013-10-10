<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gardening Management System</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
<script type="text/javascript">
function f()
{
var username=document.getElementById("lemail").value;
var password=document.getElementById("password").value;
if(username==null|| username=="")
	{
	alert("Email can't be blank");
	return false;
	}
else
	{
	if(password==null||password=="")
		{
		alert("Password can't be blank");
		return false;
		}
	else
		{
		return true;
		}
	}
}
</script>
</head>
<body>
<form name="Loginexpertuser" method="post" action="ExpertloginServlet" onsubmit="return f()">
<div id="header">
<center>	
<br>
<h1>Gardening Management System</h1>
	<h2>&nbsp;</h2>
	<br>
	</center>
</div>

<div id="menu">
	<ul>
		<li ><a href="userlogin.jsp">UserLogin</a></li>
		<li id="first" class="active">
		  <div align="center" ><a href="expertlogin.jsp">ExpertUserLogin</a></div>
		</li>
	</ul>
	<div></div>
</div>
<br>
<div id="container">
	<div id="primarycontainer">
	  <div id="primarycontent">
	  <table width="100%">
	  	  	  <tr>
<td><div align=left>
<img border="0" src="image.jpg" alt="Pulpit rock" width="304" height="228">
</div>
</td>

<td align="center" >
	<%
							String errormessage="";
							if(session.getAttribute("experterror")!=null)
							{
							errormessage=(String)session.getAttribute("experterror");
							}
							else{
								errormessage="";
							}
							%>
							<div id="error" align="center">
							<font color="red"><%=errormessage%></font>
							</div>

 
	  <strong>Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong><input type="text" size="30" id="lemail" name="lemail"/><br>
	  <br>
	  <strong>Password:&nbsp;&nbsp;</strong><input type="password" size="30" id="password"name="password"/><br>
	  <br>
	  <div align="center"><input type="submit" name="submit" value="Submit"/><input type="reset" value="Reset"/></div>
	  <br>
	 
	  
	  </td>
	  	    
	
	  </table>
	  
	  <% errormessage=""; %>
</div>
</div>
</div>
<div id="secondarycontent">
   <p>&nbsp;</p>
  </div>
	<div class="clearit"></div>

<div id="footer">
	<strong>SSDI Team 3</strong></div>
</form>

</body>
</html>