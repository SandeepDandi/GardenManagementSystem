package ssdi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		HttpSession session= request.getSession();
		PrintWriter out= response.getWriter();
		String email=request.getParameter("uemail");
		
		String password=request.getParameter("lpassword");
		String usertype="user";
		boolean validate = buslogic.validate(email, password,usertype);
		if(validate==true)
		{
			String username=buslogic.getusername(email);
			session.setAttribute("username", username);
			session.setAttribute("useremail", email);
			  session.setAttribute("loginvalidate", validate);
	    	   response.sendRedirect("welcomeuser.jsp");
	       }
	       else
	       {
	    	   String error="Invalid Credentials";
	    	   session.setAttribute("error", error);
	    	   response.sendRedirect("userlogin.jsp");
	       }
		out.println("<table>"+
	       "<tr>"+
				"<td>"+
	       "</table>");
			
		
	
	}

}
