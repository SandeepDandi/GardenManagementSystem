package ssdi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BrowseGardenServlet
 */
public class BrowseGardenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowseGardenServlet() {
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
		//String username=(String)session.getAttribute("expertusername");
		//String expertuseremail=(String)session.getAttribute("useremail");
		String pname=(String)request.getParameter("pname");
		String gnumber=(String)request.getParameter("gnumber");
		String advice=(String)request.getParameter("advice");
		String status=(String)request.getParameter("status");
		String email=(String)request.getParameter("email");
		String result=null;
		
		List<report> reports=null;
		buslogic b=new buslogic();
		if(advice!=null )
		{
			result=buslogic.adviceuser(pname,email,gnumber,status,advice);
		}
		else
		{
		try{
			reports=b.browsegarden();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
        request.setAttribute("browsegardenresult", result);
		request.setAttribute("browsegarden", reports);
		request.getRequestDispatcher("browsegarden.jsp").forward(request, response);
	}

}
