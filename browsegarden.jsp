<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,ssdi.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gardening Management System</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script>
	function f() {
		var status = document.getElementById("status").value;
		var advice = document.getElementById("advice").value;
		if (status == null || status == "") {
			alert("Status can't be blank");
			return false;
		} else {
			if (advice == null || advice == "") {
				alert("Advice can't be blank");
				return false;
			} else {
				return true;
			}
		}
	}
</script>


</head>
<body>
	<form method="post" action="BrowseGardenServlet" onsubmit="return f()">
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
							<li><a href="manageplantinventory.jsp">Manage Plant
									Inventory</a></li>
							<li id="first" class="active">
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
					<center>
						<input type="submit" name="Browse Garden" value="Browse Gardens" />
						
						<%
							String errormessage = (String) request
									.getAttribute("browsegardenresult");
							if (errormessage != null) {
						%>
						<div id="error" align="center">
							<font color="red"><%=errormessage%></font>
						</div>
						<%
							}
						%>
						<%
							List<report> browsegarden = (List<report>) request.getAttribute("browsegarden");
							if (browsegarden != null) {
								if (browsegarden.size() > 0) {
						%>
						<table border="1" width="40%">
							<tr>
								<td>Users</td>
								<td>Garden Number</td>
								<td>Plant Name</td>
								<td>User Performed Actions</td> 
								<td>Previous Status</td>
								<td>Previous Advice</td>
								<td>Status</td>
								<td>Advice</td>
								<td>Action</td>
							</tr>

							<%
								for (report r : browsegarden) {
							%>
							<form method="post" action="BrowseGardenServlet">
								<tr>
									<td><%=r.getEmail()%></td>
									<td><%=r.getGardennumber()%></td>
									<td><%=r.getPlantname()%></td>
									<td><%=r.getActionperformed() %></td>
									<td><%=r.getStatus()%></td>
									<td><%=r.getComments()%></td>
									<td><input type="text" name="status" id="status"></td>
									<td><input type="text" name="advice" id="advice"></td>
									<td><input type="submit" name="submit" value="Submit" /></td>
									<input type="hidden" name="pname" value="<%=r.getPlantname()%>">
									<input type="hidden" name="gnumber"	value="<%=r.getGardennumber()%>">
									<input type="hidden" name="email" value="<%= r.getEmail() %>">
							</form>
							</tr>

							<%
								}
							%>
						</table>
						<%
							}
							}
						%>

					</center>

				</div>
			</div>
		</div>
		<div id="secondarycontent">
			<p>&nbsp;</p>
		</div>
		<div class="clearit"></div>
		</div>
		<div id="footer">
			<strong>SSDI Team 3</strong>
		</div>
	</form>
</body>
</html>