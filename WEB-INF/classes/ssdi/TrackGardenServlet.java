package ssdi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TrackGardenServlet
 */
public class TrackGardenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackGardenServlet() {
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
		String pname=(String)request.getParameter("pname");
		String gnumber=(String)request.getParameter("gnumber");
		String actionperformed=(String)request.getParameter("actionperformed");
		String result=null;
		System.out.println(actionperformed);
		List<report> reports=null;
		buslogic b=new buslogic();
		if(actionperformed!=null )
		{
			result=buslogic.actionperformed(pname,email,gnumber,actionperformed);
		}
		else
		{
		try{
			reports=b.viewgarden(email, username);
			System.out.println(reports);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
        request.setAttribute("trackgardenresult", result);
		request.setAttribute("trackgarden", reports);
		request.getRequestDispatcher("trackgarden.jsp").forward(request, response);
	}

}
