package ssdi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ManageGardenServlet
 */
public class ManageGardenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageGardenServlet() {
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
		String viewlist=(String)request.getParameter("viewlist");
		String add=(String)request.getParameter("add");
		String delete=(String)request.getParameter("delete");
		String username=(String)session.getAttribute("username");
		String addgardennumber=(String)request.getParameter("addgardennumber");
		String deletegardennumber=(String)request.getParameter("deletegardennumber");
		String deleteplantname=(String)request.getParameter("deleteplantname");
		String addplantname=(String)request.getParameter("addplantname");
		String email=(String)session.getAttribute("useremail");
		String result=null;
		System.out.println(""+viewlist);
		System.out.println(""+add);
		System.out.println(""+delete);
		List<report> reports=null;
		buslogic b=new buslogic();
		if(viewlist!=null)
		{
			System.out.println(viewlist);	
			try{
				reports=b.viewgarden(email, username);
				System.out.println(reports);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(delete!=null)
		{
			try
			{
				result=buslogic.deleteplantfromgarden(deleteplantname,email,deletegardennumber);
			}
			catch(Exception e)
			{
               e.printStackTrace();
			}
		}
		if(add!=null)
		{
			try
			{
				result=buslogic.addplanttogarden(addplantname,email,addgardennumber);
			}
			catch(Exception e)
			{
               e.printStackTrace();
			}
		}
		request.setAttribute("managegardenresult", result);
		request.setAttribute("viewlist", reports);
		request.getRequestDispatcher("managegarden.jsp").forward(request, response);
	}

}
