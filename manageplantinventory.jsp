<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gardening Management System</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript">
	function f() 
	{
		alert("-------->");
		varchar	plantname = document.getElementById("plantname").value();
		if (plantname == null || plantname =="") {
			alert("plant name can't be blank");
			return false;
		}
		else
			{
			return true;
			}
	}
</script>
</head>
<body>
	<form method="post" action="MPlServlet" onsubmit="return f()">
		<div id="header">
			<center>
				<br>
				<h1>Gardening Management System</h1>
				<h2>&nbsp;</h2>
				<br>
			</center>
		</div>

		<div id="menu">
			<table width="100%">
				<tr>
					<td>
						<ul>
							<li id="first" class="active"><a
								href="manageplantinventory.jsp">Manage Plant Inventory</a></li>
							<li>
								<div align="center">
									<a href="browsegarden.jsp">Browse Gardens and Advice Users</a>
								</div>
							</li>
							<li><a href="expertviewreport.jsp">View Reports</a></li>
						</ul>
					</td>
					<td align="right">
						<ul align="right">
							<div align="right">
								<li><a href="logoutServlet">Logout</a></li>
							</div>

						</ul>
					</td>
				</tr>
			</table>

			<div></div>
		</div>
		<br>
		<div id="container">
			<div id="primarycontainer">
				<div id="primarycontent">
					
							Enter Plant Name:<input type="text" name="deleteplantname">
							<input type="submit" name="submit" value="Delete" />
						
					<br> <br>
					<%
							String errormessage=(String)request.getAttribute("addplantresult");
							if(errormessage!=null)
							{ %>
								<div id="error" align="center">
								<font color="red"><%=errormessage%></font>
							</div>
							<%} errormessage="";%>
							
					
					<table>

						<tr>
							<td>Plant Name:&nbsp;<input type="text" name="plantname"
								id="plantname" />
							</td>
							<td>Soil Type:<select name='soiltype' id='soiltype'>
									<option value='select' selected="selected">Select</option>
									<option value='Red Soil'>Red Soil</option>
									<option value='Black Soil'>Black Soil</option>
									<option value='White Soil'>White Soil</option>
							</select>
							</td>
						</tr>
						<tr>
							<td>Moisture: <select name='moisture' id='moisture'>
									<option value='select' selected="selected">Select</option>
									<option value='high'>High</option>
									<option value='Medium'>Medium</option>
									<option value='Low'>Low</option>
							</select>
							</td>
							<td>Sun Exposure: <select name='sunexposure'
								id='sunexposure'>
									<option value='select' selected="selected">Select</option>
									<option value='high'>High</option>
									<option value='Medium'>Medium</option>
									<option value='Low'>Low</option>
							</select>
							</td>
						</tr>
						<tr>
							<td colspan="2">Geographic Region:<select name='region'
								id='region'>
									<option value='select' selected="selected">Select</option>
									<option value='North'>North</option>
									<option value='East'>East</option>
									<option value='South'>South</option>
									<option value='West'>West</option>
							</select>
							</td>
						</tr>
						<tr>
							<td colspan="2">Description:(Not more than 50 words)<br>
								<textarea rows="4" cols="50" name="description">
	  </textarea>
							</td>
						</tr>
						<tr>
							<td align="center"><input type="submit" name="submit"
								value="Add" /></td>
							<td><a href="welcomeexpert.jsp"><u>return to account</u></a>
							</td>
						</tr>
					</table>
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