package userApplication;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		if(c==null) {
			pw.println("Session Expired...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else {

			ServletContext sct=this.getServletContext();
			UserBean ub=(UserBean) sct.getAttribute("ub");
			ub.setAddr(req.getParameter("addr"));
			ub.setMid(req.getParameter("mid"));
			String phoneNumber = req.getParameter("phno").trim();
			if (phoneNumber.matches("\\d{10}")) { // 10-digit phone number
			    try {
			        ub.setPnum(Long.parseLong(phoneNumber));
			    } catch (NumberFormatException e) {
			        System.err.println("Invalid phone number format: " + e.getMessage());
			    }
			} else {
			    System.err.println("Invalid phone number format. Please enter a 10-digit number.");
			}

			int k=new UpdateProfileDAO().update(ub);
			if(k>0) {
				pw.println("Page belongs to "+ub.getFname()+"<br>");
				pw.println("Profile Updated Sucessfully...<br>");
				RequestDispatcher rd=req.getRequestDispatcher("link.html");
				rd.include(req, res);
			}

		}

	}

}
