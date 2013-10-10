package ssdi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ssdi.dcc;
public class buslogic {
	public static boolean validate(String username,String password,String usertype)
	{
		Connection con;
		Statement s;
		ResultSet rs;

		String sql="select password from userdetails where email='"+username+"' and usertype='"+usertype+"'";
		try
		{
			con=dcc.getconnection();
			s=con.createStatement();
			rs=s.executeQuery(sql);

			if(rs.next())
			{

				String pass=rs.getString("password");

				if(pass.equals(password))
				{
					System.out.println(""+pass);
					return true;
				}
				else
				{
					return false;	
				}
			}
			else
			{
				return false;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean registerValidate(String firstname,String lastname,String email,String password)
	{
		Connection con;
		Statement s,s1;
		ResultSet rs;

		String sql="select * from userdetails where email='"+email+"'";
		String sql1="INSERT INTO  userdetails VALUES('"+firstname+"','"+lastname+"','"+email+"','"+password+"','user')";
		try
		{
			con=dcc.getconnection();
			s=con.createStatement();
			s1=con.createStatement();
			rs=s.executeQuery(sql);


			if(rs.next())
			{
				return false;
			}
			else
			{
				s1.executeQuery(sql1);
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;

	}

	public static String addplant(String plantname,String region,String soiltype,String sunexposure,String moisture,String description)
	{
		Connection con;
		Statement s,s1;
		ResultSet rs;

		String sql="select * from plant where name='"+plantname+"'";
		String sql1="insert into  plant(name,region,soiltype,sunexposure,moisture,description) values('"+plantname+"','"+region+"','"+soiltype+"','"+sunexposure+"','"+moisture+"','"+description+"')";
		String result="";
		try
		{
			con=dcc.getconnection();
			s=con.createStatement();
			s1=con.createStatement();
			rs=s.executeQuery(sql);


			if(rs.next())
			{
				result="Plant name already exits";
				return result;
			}
			else
			{
				s1.executeQuery(sql1);
				result="Succesfully added the plant";
				return result;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		result="Error in adding the plant Please try once again";
		return result;

	}

	public static String deleteplant(String plantname)
	{
		Connection con;
		Statement s,s1;
		ResultSet rs;

		String sql="select * from plant where name='"+plantname+"'";
		String sql1="delete from plant where name='"+plantname+"'";
		String result="";
		try
		{
			con=dcc.getconnection();
			s=con.createStatement();
			s1=con.createStatement();
			rs=s.executeQuery(sql);


			if(rs.next())
			{
				s1.executeQuery(sql1);
				result="Succesfully deleted the plant";

				return result;
			}
			else
			{
				result="Plant name does not exits";
				return result;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		result="Error in deleting the plant Please try once again";
		return result;

	}
	public static String deleteplantfromgarden(String plantname,String email,String gardennumber)
	{
		Connection con;
		Statement s,s1,s2;
		ResultSet rs;

		String sql="select * from garden where plantname='"+plantname+"' and email='"+email+"'and gardennumber='"+gardennumber+"'";
		String sql1="delete from garden where plantname='"+plantname+"'and email='"+email+"'and gardennumber='"+gardennumber+"'";
		String sql2="delete from report where plantname='"+plantname+"'and email='"+email+"'and gardennumber='"+gardennumber+"'";
		String result="";
		try
		{
			con=dcc.getconnection();
			s=con.createStatement();
			s1=con.createStatement();
			s2=con.createStatement();
			rs=s.executeQuery(sql);


			if(rs.next())
			{
				s1.executeQuery(sql1);
				s2.executeQuery(sql2);
				result="Succesfully deleted the plant from garden";
				return result;
			}
			else
			{
				result="Plant name does not exits in the garden";
				return result;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		result="Error in deleting the plant from garden Please try once again";
		return result;

	}
	public static String addplanttogarden(String plantname,String email,String gardennumber)
	{
		Connection con;
		Statement s,s1,s2;
		ResultSet rs;

		String sql="select * from garden where plantname='"+plantname+"' and email='"+email+"'and gardennumber='"+gardennumber+"'";
		String sql1="insert into garden(plantname,gardennumber,email)  values('"+plantname+"','"+gardennumber+"','"+email+"')";
		String sql2="insert into report(email,plantname,gardennumber,comments,status,actionperformed) values('"+email+"','"+plantname+"','"+gardennumber+"','Not Reviewed','Not Reviewed','No Actions Performed')";
		String result="";
		try
		{
			con=dcc.getconnection();
			s=con.createStatement();
			s1=con.createStatement();
			s2=con.createStatement();
			rs=s.executeQuery(sql);


			if(rs.next())
			{
				result="Plant is already added";
				return result;
			}
			else
			{
				s1.executeQuery(sql1);
				s2.executeQuery(sql2);
				result="Succesfully added the plant to garden";
				return result;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		result="Error in adding the plant from garden Please try once again";
		return result;

	}
	public static String actionperformed(String plantname,String email,String gardennumber,String actionperformed)
	{
		Connection con;
		Statement s,s1;
		ResultSet rs;

		String sql="select * from report where plantname='"+plantname+"' and email='"+email+"'and gardennumber='"+gardennumber+"'";

		String sql1="update report set actionperformed='"+actionperformed+"' where plantname='"+plantname+"' and email='"+email+"'and gardennumber='"+gardennumber+"'"; 
		String result="";
		try
		{
			con=dcc.getconnection();
			s=con.createStatement();
			s1=con.createStatement();
			rs=s.executeQuery(sql);


			if(rs.next())
			{
				s1.executeQuery(sql1);
				result="Successfuly submitted the Action Performed";
				return result;
			}
			else
			{

				result="Plant is does not exists in garden";
				return result;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		result="Error in submitting the action performed Please try once again";
		return result;

	}
	public static String adviceuser(String plantname,String email,String gardennumber,String status,String advice)
	{
		Connection con;
		Statement s,s1;
		ResultSet rs;

		String sql="select * from report where plantname='"+plantname+"' and email='"+email+"'and gardennumber='"+gardennumber+"'";

		String sql1="update report set comments='"+advice+"',status='"+status+"' where plantname='"+plantname+"' and email='"+email+"'and gardennumber='"+gardennumber+"'"; 
		String result="";
		try
		{
			con=dcc.getconnection();
			s=con.createStatement();
			s1=con.createStatement();
			rs=s.executeQuery(sql);


			if(rs.next())
			{
				s1.executeQuery(sql1);
				result="Successfuly submitted the Status and Advice";
				return result;
			}
			else
			{

				result="Plant in that garden for particular User does not exists";
				return result;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		result="Error in submitting the advice and status Please try once again";
		return result;

	}

	public static String getusername(String email)
	{
		Connection con;
		Statement s;
		ResultSet rs;

		String sql="select * from userdetails where email='"+email+"'";


		String username="";
		try
		{
			con=dcc.getconnection();
			s=con.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next())
			{
				username=(String)rs.getString("firstname");
				return username;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		username="Error in getting the username";
		return username;

	}

	public static String generategarden(String email,String plantname,String gardennumber)
	{
		Connection con;
		Statement s,s1;

		String sql="insert into garden values('"+plantname+"','"+gardennumber+"','"+email+"')";
		String sql1="insert into report(plantname,gardennumber,email,status,comments,actionperformed) values('"+plantname+"','"+gardennumber+"','"+email+"','Not Reviewed','Not Reviewed','No Actions Performed')";

		String result="";
		try
		{
			con=dcc.getconnection();
			s=con.createStatement();
			s1=con.createStatement();
			s.executeQuery(sql);
			s1.executeQuery(sql1);
			result="Successfully added the plant to the garden";
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		result="Error in adding the plant to the garden";
		return result;

	}

	public List<plant> browse(String name) throws SQLException{
		Connection con = null;
		Statement s = null;
		ResultSet rs = null;
		List<plant> plants=new ArrayList<plant>();
		String sql="select * from plant where name='"+name+"'";
		try{
			con=dcc.getconnection();
			s=con.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next())
			{
				plant Plant=new plant();
				Plant.setPlantName(rs.getString("name"));
				Plant.setRegion(rs.getString("region"));
				Plant.setSoiltype(rs.getString("soiltype"));
				Plant.setSunexposure(rs.getString("sunexposure"));
				Plant.setMoisture(rs.getString("moisture"));
				Plant.setDescription(rs.getString("description"));
				plants.add(Plant);
			}
		}
		finally {
			if(rs!=null)
			{
				try
				{
					rs.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(s!=null)
			{
				try
				{
					s.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return plants;
	}
	public List<report> viewgarden(String email,String username) throws SQLException{
		Connection con = null;
		Statement s = null;
		ResultSet rs = null;
		List<report> reports=new ArrayList<report>();
		String sql="select * from report where email='"+email+"'";
		try{
			con=dcc.getconnection();
			s=con.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next())
			{
				report Report=new report();
				Report.setComments(rs.getString("comments"));
				Report.setEmail(rs.getString("email"));
				Report.setGardennumber(rs.getInt("gardennumber"));
				Report.setPlantname(rs.getString("plantname"));
				Report.setStatus(rs.getString("status"));
				Report.setUsername(username);
				Report.setActionperformed(rs.getString("actionperformed"));

				reports.add(Report);
			}
		}
		finally {
			if(rs!=null)
			{
				try
				{
					rs.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(s!=null)
			{
				try
				{
					s.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return reports;
	}
	public List<report> browsegarden() throws SQLException{
		Connection con = null;
		Statement s = null;
		ResultSet rs = null;
		String email=null;
		List<report> reports=new ArrayList<report>();
		String sql="select * from report";
		buslogic b=new buslogic();
		try{
			con=dcc.getconnection();
			s=con.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next())
			{
				report Report=new report();
				Report.setComments(rs.getString("comments"));
				email=(String)rs.getString("email");
				Report.setEmail(email);
				Report.setGardennumber(rs.getInt("gardennumber"));
				Report.setPlantname(rs.getString("plantname"));
				Report.setStatus(rs.getString("status"));
				Report.setUsername("");
				Report.setActionperformed(rs.getString("actionperformed"));

				reports.add(Report);
			}
		}
		finally {
			if(rs!=null)
			{
				try
				{
					rs.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(s!=null)
			{
				try
				{
					s.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return reports;
	}
	public List<report> browsegarden(String email) throws SQLException{
		Connection con = null;
		Statement s = null;
		ResultSet rs = null;
		
		List<report> reports=new ArrayList<report>();
		String sql="select * from report where email='"+email+"'";
		buslogic b=new buslogic();
		try{
			con=dcc.getconnection();
			s=con.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next())
			{
				report Report=new report();
				Report.setComments(rs.getString("comments"));
				Report.setEmail(rs.getString("email"));
				Report.setGardennumber(rs.getInt("gardennumber"));
				Report.setPlantname(rs.getString("plantname"));
				Report.setStatus(rs.getString("status"));
				Report.setUsername("");
				Report.setActionperformed(rs.getString("actionperformed"));

				reports.add(Report);
			}
		}
		finally {
			if(rs!=null)
			{
				try
				{
					rs.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(s!=null)
			{
				try
				{
					s.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return reports;
	}
	public List<plant> getplantlist(String moisture,String sunexposure,String soiltype,String region) throws SQLException{
		Connection con = null;
		Statement s = null;
		ResultSet rs = null;
		List<plant> plants=new ArrayList<plant>();
		String sql="select * from plant where moisture='"+moisture+"' and sunexposure='"+sunexposure+"' and soiltype='"+soiltype+"' and region='"+region+"'";
		try{
			con=dcc.getconnection();
			s=con.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next())
			{
				plant Plant=new plant();
				Plant.setPlantName(rs.getString("name"));
				Plant.setRegion(rs.getString("region"));
				Plant.setSoiltype(rs.getString("soiltype"));
				Plant.setSunexposure(rs.getString("sunexposure"));
				Plant.setMoisture(rs.getString("moisture"));
				Plant.setDescription(rs.getString("description"));
				plants.add(Plant);
			}
		}
		finally {
			if(rs!=null)
			{
				try
				{
					rs.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(s!=null)
			{
				try
				{
					s.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return plants;
	}

	public static void main(String Args[])
	{
		Connection con;
		con=dcc.getconnection();
		if(con!=null)
		{
			System.out.println("Connection Established");
		}
		else{
			System.out.println("Connection Failed");
		}

	}
}
