<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script>
	function f() {
		var username = document.getElementById("uemail").value;
		var password = document.getElementById("lpassword").value;
		if (username == null || username == "") {
			alert("Enter the email_id");
			return false;
		} else {
			if (password == null || password == "") {
				alert("Enter the password");
				return false;
			} else {
				return true;
			}
		}
	}
</script>
</head>
<body>
	<form name="Loginnewuser" method="post" action="LoginServlet" onsubmit="return f()" >
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
				<li id="first" class="active"><a href="userlogin.jsp">UserLogin</a></li>
				<li>
					<div align="center">
						<a href="expertlogin.jsp">ExpertUserLogin</a>
					</div>
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
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><div align=left>
									<img border="0" src="image.jpg" alt="Pulpit rock" width="304"
										height="228">
								</div></td>
							<td align="center">
							<%
							String errormessage=(String)session.getAttribute("error");
							if(errormessage!=null)
							{
							%>
							<div id="error" align="center">
							<font color="red"><%=errormessage%></font>
							</div>
							<%} %>
							<strong>Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong><input
								type="text" size="30" id="uemail" name="uemail" /><br> <br>
								<strong>Password:&nbsp;&nbsp;</strong><input type="password"
								size="30" id="lpassword" name="lpassword" /><br> <br>
								<div align="center">
									<input type="submit" name="submit" value="Submit" /><input
										type="reset" value="Reset" />
								</div> <br> <a href="register.jsp"><u>New users click
										here to register</u></a></td>
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

			<strong>SSDI Team 3</strong>
		</div>
	</form>
</body>
</html>