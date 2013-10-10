<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.*,ssdi.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Garden</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body> 
<form  method="post" action="GenerateGardenServlet">
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
		<li id="first" class="active"><a href="generategarden.jsp">Generate Garden</a></li>
		<li >
		  <div align="center" ><a href="managegarden.jsp">Manage Garden</a></div>
		</li>
		<li ><a href="trackgarden.jsp">Track Garden</a></li>
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
	  <table>
	  <tr>
	  <td>
	  Soil Type:<select name='soiltype' id='soiltype'>
									<option value='select' selected="selected">Select</option>
									<option value='Red Soil'>Red Soil</option>
									<option value='Black Soil'>Black Soil</option>
									<option value='White Soil'>White Soil</option>
							</select>

	  </td>
	   <td>
	  Moisture:<select name='moisture' id='moisture'>
									<option value='select' selected="selected">Select</option>
									<option value='high'>High</option>
									<option value='Medium'>Medium</option>
									<option value='Low'>Low</option>
							</select>
	  </td>
	  </tr>
	   <tr>
	  <td>
	  Sun Exposure:<select name='sunexposure'
								id='sunexposure'>
									<option value='select' selected="selected">Select</option>
									<option value='high'>High</option>
									<option value='Medium'>Medium</option>
									<option value='Low'>Low</option>
							</select>

	  </td>
	   <td>
	  Geographic Region:<select name='region'
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
	  <td align="center">
	   <input type="submit" name="submit" value="Submit"/>
	  </td>
	   <td>
	  <a href="welcomeuser.jsp"><u>return to account</u></a>
	  </td>
	  </tr>
	  </table>
	  <br>
	  <br>
	  <%
							String errormessage=(String)request.getAttribute("generateresult");
							if(errormessage!=null)
							{
							%>
							<div id="error" align="center">
							<font color="red"><%=errormessage%></font>
							</div>
							<%} %>
	  <% 
List<plant> listplant=(List<plant>)request.getAttribute("listplant");
if(listplant!=null)
{
	if(listplant.size()>0)
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
	  <td>Enter Garden Number</td>
	  <td>Action</td>
	  	  </tr>
	   
	   <%
	for(plant p:listplant){	   
		 %>
		<form  method="post" action="GenerateGardenServlet">
		<tr> <td><%=p.getPlantName() %></td>
		<td><%=p.getRegion() %></td>
		<td><%=p.getSoiltype() %></td>
		<td><%=p.getSunexposure() %></td>
		<td><%=p.getMoisture() %></td>
		<td><%=p.getDescription() %></td>
		<td><input type="text" name="gardennumber" id="gardennumber"></td>
		 <td><input type="submit" name="submit" value="Add"/></td>
		 <input type="hidden" name="pname" value="<%=p.getPlantName()%>" >
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