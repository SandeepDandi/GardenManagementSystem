package ssdi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ExpertloginServlet
 */
public class ExpertloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExpertloginServlet() {
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
		HttpSession session = request.getSession();
		String email=request.getParameter("lemail");
		String password=request.getParameter("password");
		String usertype="expert";
		boolean validate = buslogic.validate(email, password,usertype);
		if(validate==true)
		{
			String username=buslogic.getusername(email);
			session.setAttribute("expertusername", username);
			session.setAttribute("expertuseremail", "email");
			response.sendRedirect("welcomeexpert.jsp");
		}
		else
		{
			String error="Invalid Credentials";
			session.setAttribute("experterror", error);
			response.sendRedirect("expertlogin.jsp");
		}
	}

}
