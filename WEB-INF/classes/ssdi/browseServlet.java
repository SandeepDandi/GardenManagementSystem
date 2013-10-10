package ssdi;

import java.io.IOException;
//import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class browseServlet
 */
public class browseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public browseServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String search=request.getParameter("search");
		buslogic bus=new buslogic();
		List<plant> plants=null;
		try{

			plants=bus.browse(search);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//request.getRequestDispatcher("browse.jsp").set
		request.setAttribute("plants", plants);
		//request.setAttribute("dandi", plants.get(0));
		
		request.getRequestDispatcher("browse.jsp").forward(request, response);
	}

}
