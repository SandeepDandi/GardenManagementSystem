package ssdi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GenerateGardenServlet
 */
public class GenerateGardenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GenerateGardenServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       HttpSession session=request.getSession(false);
		String moisture=request.getParameter("moisture");
		String sunexposure=request.getParameter("sunexposure");
		String soiltype=request.getParameter("soiltype");
		String region=request.getParameter("region");
		String pname=request.getParameter("pname");
		String gardennumber=request.getParameter("gardennumber");
		System.out.println("soiltype: "+soiltype);
		System.out.println("moisture: "+moisture);
		System.out.println("region: "+region);
		System.out.println("sunexposure: "+sunexposure);
		buslogic b=new buslogic();
		List<plant> plantlist=null;
		String result=null;
		String email=(String)session.getAttribute("useremail");
		System.out.println(pname);
		if( pname!= null)
		{
			System.out.println(pname);
		       result=buslogic.generategarden(email,pname,gardennumber);
		       request.setAttribute("generateresult", result);
		}
		else{
			
		
			try
			{
				plantlist=b.getplantlist(moisture,sunexposure,soiltype,region);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			request.setAttribute("listplant", plantlist);
		}
		
		
		request.getRequestDispatcher("generategarden.jsp").forward(request, response);

	}

}
