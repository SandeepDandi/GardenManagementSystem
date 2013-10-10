<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,ssdi.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gardening Management System</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body> 
<form method="post" action="ViewReportServlet">
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
		<li ><a href="generategarden.jsp">Generate Garden</a></li>
		<li >
		  <div align="center" ><a href="managegarden.jsp">Manage Garden</a></div>
		</li>
		<li ><a href="trackgarden.jsp">Track Garden</a></li>
		<li id="first" class="active" >
		  <div align="center"  ><a href="viewreport.jsp">View Report</a></div>
		</li>
		<li ><a href="browse.jsp">Browse</a></li>
	</ul>
	</td>
	<td align="right">
	<ul align="right">
		<div align="right"><li ><a href="logoutServlet">Logout</a></li></div>
		
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
<input type="submit" name="submit" value="View Report">
<%
List<report> reports=(List<report>)request.getAttribute("viewreport");
if(reports !=null)
{
	if(reports.size()>0)
	{
%>
<table width="60%" border="1">

	<tr>
	     <td   width="*" align="center">Garden Number</td>
		 <td   width="*" align="center">Plant Grown</td>
		 <td   width="*" align="center">Status</td>
		 <td   width="*" align="center">Advice from Expert</td>
		
	</tr>
	<%for(report r:reports) {%>
	<tr>
	<td><%= r.getGardennumber()%></td>
	<td><%= r.getPlantname()%></td>
	<td><%= r.getStatus()%></td>
	<td><%= r.getComments()%></td>
	</tr>
	<%}} %>
	</table>
	<%} %>
	
</center>

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