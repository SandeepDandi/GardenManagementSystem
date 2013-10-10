<%@ page language="java" import="java.util.*,ssdi.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Browse</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
<script type="text/javascript">
function f()
{
	var search= document.getElementById("search").value;
if(search==null||search=="")
	{
	 alert("search can't be blank");
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
<form method="post" action="browseServlet" onsubmit="return f()">
<div id="header">
<center>	
<br>
<h1>Gardening Management System</h1>
	<h2>&nbsp;</h2>
	<br>
	</center>
</div>

<div id="menu">
<table width="100%" >
	<tr>
	<td>
	<ul>
		<li><a href="generategarden.jsp">Generate Garden</a></li>
		<li >
		  <div align="center" ><a href="managegarden.jsp">Manage Garden</a></div>
		</li>
		<li ><a href="trackgarden.jsp">Track Garden</a></li>
		<li >
		  <div align="center" ><a href="viewreport.jsp">View Report</a></div>
		</li>
		<li  id="first" class="active"><a href="browse.jsp">Browse</a></li>
	</ul>
	</td>
	<td align="right">
	<ul >
		<li ><a href="logoutServlet">Logout</a></li>
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
<table width="50%" height="50%" >
<tr>
<td>
<input type="text" size="30" id="search" name="search"/> &nbsp;
<input type="submit" value="Search"/>
<td>
<td>
<a href="welcomeuser.jsp"><u>return to account</u></a>
</td>
</tr>
</table>
<br>
<br>
<% 
List<plant> plants=(List<plant>)request.getAttribute("plants");
if(plants!=null)
{
	if(plants.size()>0)
	{
%>
<table border="1" width="40%">
	  <tr>
	  <td>Plant Name</td>
	  <td>Region</td>
	  <td>SoilType</td>
	  <td>SunExposure</td>
	  <td>Moisture</td>
	  <td>Description</td>
	  	  </tr>
	   
	   <%
	for(plant p:plants){	   
		 %>
		<tr> <td><%=p.getPlantName() %></td>
		<td><%=p.getRegion() %></td>
		<td><%=p.getSoiltype() %></td>
		<td><%=p.getSunexposure() %></td>
		<td><%=p.getMoisture() %></td>
		<td><%=p.getDescription() %></td>
		 
		</tr> 
		 <%}} %>
	   
	  
	 </table>
	<%
}
%>
</center>

</div>
</div>
</div>
<div id="secondarycontent">
   <p>&nbsp;</p>
  </div>
	<div class="clearit">
	</div>
<div id="footer">
	<strong>SSDI Team 3</strong></div>
</form>
</body>
</html>