package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/viewBook")
public class UserViewBooksServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","<h3 style='color: red;'>Session Expired...</h3><br>");
			req.getRequestDispatcher("userRegister.jsp");
		}
		else {
			 ArrayList<BookBean> al=new UserViewBooksDAO().viewBooks();
			hs.setAttribute("al", al);
			req.getRequestDispatcher("UserViewBooks.jsp").forward(req, res);
		}
	}
}
