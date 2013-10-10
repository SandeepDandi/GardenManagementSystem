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
<form method="post" action="TrackGardenServlet">
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
		<li id="first" class="active"><a href="trackgarden.jsp">Track Garden</a></li>
		<li >
		  <div align="center" ><a href="viewreport.jsp">View Report</a></div>
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

	<input type="submit"  name="submit" value="Track Garden"/>

	<%
							String errormessage=(String)request.getAttribute("trackgardenresult");
							if(errormessage!=null)
							{
							%>
							<div id="error" align="center">
							<font color="red"><%=errormessage%></font>
							</div>
							<%} %>
	  <% 
List<report> listgarden=(List<report>)request.getAttribute("trackgarden");
if(listgarden!=null)
{
	if(listgarden.size()>0)
	{
%>
<table border="1" width="40%">
	  <tr>
	  <td>Garden Number</td>
	  <td>Plant Name</td>
	  <td>Things To Do</td>
	  <td>Previous Actions Performed</td>
	  <td>Actions Performed</td>
	  <td>Action</td>
	   </tr>
	   
	   <%
	for(report r:listgarden){	   
		 %>
		<form  method="post" action="TrackGardenServlet">
		<tr> <td><%=r.getGardennumber() %></td>
		<td><%=r.getPlantname()%></td>
		<td><%=r.getComments() %></td>
		<td><%=r.getActionperformed() %></td>
	    <td><input type="text" name="actionperformed" id="actionperformed"></td>
		 <td><input type="submit" name="submit" value="Submit"/></td>
		 <input type="hidden" name="pname" value="<%=r.getPlantname()%>" >
		 <input type="hidden" name="gnumber" value="<%=r.getGardennumber() %>">
		 </form>
		</tr> 
		
		 <%} %>
		 
		 
		 
								
		 
	    </table>
	   <%}} %>
	
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