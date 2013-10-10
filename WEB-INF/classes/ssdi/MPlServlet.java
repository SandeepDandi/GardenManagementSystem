package ssdi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MPlServlet
 */
public class MPlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MPlServlet() {
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
		HttpSession session = null;
		String deleteplantname=request.getParameter("deleteplantname");
		String result = null;
				if(deleteplantname.length()>0)
					{
					deleteplantname=request.getParameter("deleteplantname");
					System.out.println(""+deleteplantname);
					result=buslogic.deleteplant(deleteplantname);
					}
				else
				{
		String plantname=request.getParameter("plantname");
		String moisture=request.getParameter("moisture");
		String sunexposure=request.getParameter("sunexposure");
		String soiltype=request.getParameter("soiltype");
		String region=request.getParameter("region");
		String description=request.getParameter("description");
		System.out.println("soiltype: "+soiltype);
		System.out.println("moisture: "+moisture);
		System.out.println("region: "+region);
		System.out.println("sunexposure: "+sunexposure);
		try{
	     result=buslogic.addplant(plantname,region,soiltype, sunexposure,moisture,description);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
				}
				System.out.println(""+result);
				request.setAttribute("addplantresult",result);
			
				request.getRequestDispatcher("manageplantinventory.jsp").forward(request, response);
	}
}
