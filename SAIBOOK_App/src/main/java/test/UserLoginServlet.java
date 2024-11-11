package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		UserBean ub=new userLoginDAO().userLogin(req.getParameter("uname"),req.getParameter("pword") );
		
		if(ub!=null ) {
			HttpSession hs=req.getSession();
			hs.setAttribute("ubean", ub);
			
			req.setAttribute("msg","<h3 style='color: green;'>User Logged in Successfully...</h3><br>" );
			req.getRequestDispatcher("UserLogin.jsp").forward(req, res);
		
		}
		else{
			req.setAttribute("msg","<h3 style='color: red;'>Invalid user details......</h3><br>" );
			req.getRequestDispatcher("UserRegister.jsp").forward(req, res);
		}
}
}
