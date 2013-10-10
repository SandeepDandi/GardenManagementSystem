<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gardening Management System</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script>
function f() {
	var firstname = document.getElementById("firstname").value;
	var lastname = document.getElementById("lastname").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var cpassword = document.getElementById("cpassword").value;
	if (firstname == null || firstname == "")
	{
		alert("Firstname can't be blank");
		return false;
	} else 
	  {
		 if (lastname == null || lastname == "") 
		 {
			alert("Lastname can't be blank");
			return false;
		} else
		{
			if (email == null || email== "") 
			{
				alert("Email can't be blank");
				return false;
			} else 
			{
				if (password == null || password== "") 
				{
					alert("Password can't be blank");
					return false;
			    } 
				else
				{
				      if (cpassword == null || cpassword== "") 
				      {
					    alert("Cpassword can't be blank");
					    return false;
			          }
				      else
				      {
				            if(password==cpassword)
					         {
					           return true;
					         }
				             else
				             {
				            	 alert("Password and confirm password does not match");
				                return false;	
				             }
				      }
				}
				
			}
		}
	  }
}
</script>
</head>
<body>
	<form name="Loginnewuser" method="post" action="RegisterServlet" onsubmit= "return f()">
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
							<td><div align=left>
									<img border="0" src="image.jpg" alt="Pulpit rock" width="304"
										height="228">
								</div></td>
							<td>

								<table width="35%" height="224" border="1" align="right"
									bordercolor="#3399CC" cellspacing="0">

									<tr>
										<td>
										<%
							String errormessage="";
							if(session.getAttribute("registererror")!=null)
							{
							errormessage=(String)session.getAttribute("registererror");
							}
							else{
								errormessage="";
							}
							%>
							<div id="error" align="center">
							<font color="red"><%=errormessage%></font>
							</div>
											<table width="324" align="right">
												<tr>
													<td colspan="2"><div align="center">
															<font color="#0099CC" size="4"><b>Sign Up</b></font>
														</div></td>
												</tr>
												<tr>
													<td>&nbsp;</td>
												</tr>
												<tr>
													<td width="113"><div align="right" class="style3">
															<strong>First Name:</strong>
														</div></td>
													<td width="165"><input type="text" id="firstname" name="firstname" /></td>
												</tr>
												<tr>
													<td width="113">
														<div align="right" class="style3">
															<strong>Last Name:</strong>
														</div>
													</td>
													<td width="165"><input type="text" id="lastname" name="lastname"></td>
												</tr>
												<tr>
													<td width="113">
														<div align="right" class="style3">
															<strong>Your Email:</strong>
														</div>
													</td>
													<td width="165"><input type="text" id="email" name="email"></td>
												</tr>
												<tr>
													<td width="113">
														<div align="right" class="style3">
															<strong>Password:</strong>
														</div>
													</td>
													<td width="165"><input type="password" id="password" name="password"></td>
												</tr>
												<tr>
													<td><div align="right" class="style3">
															<strong>Confirm Password:</strong>
														</div></td>
													<td><input type="password" id="cpassword" name="cpassword"></td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td>&nbsp;</td>

												</tr>
												<tr>
													<td colspan="2"><div align="center">
															<input type="submit" name="submit" value="Submit"><input
																type="reset" name="reset" value=" Reset ">
														</div></td>

												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
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