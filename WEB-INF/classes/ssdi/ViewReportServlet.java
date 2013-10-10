package ssdi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewReportServlet
 */
public class ViewReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReportServlet() {
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
		
		String username=(String)session.getAttribute("username");
		String email=(String)session.getAttribute("useremail");
		List<report> reports=null;
		buslogic b=new buslogic();
		
			
			try{
				reports=b.viewgarden(email, username);
				System.out.println(reports);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	
		request.setAttribute("viewreport", reports);
		request.getRequestDispatcher("viewreport.jsp").forward(request, response);
		
	}

}
