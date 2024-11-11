package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/viewCart")
public class ViewCartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession hs = req.getSession(false);
		
		if (hs == null) {
			req.setAttribute("msg", "Session Expired....Try again.<br>");
			req.getRequestDispatcher("userRegister.jsp").forward(req, res);
			return; 
		}
		
		ArrayList<AddCartBean> acb=(ArrayList<AddCartBean>) hs.getAttribute("acb");
		if(acb==null || acb.size()==0) {
				req.setAttribute("msg", "<h3 style='color: green;'>The Cart is Empty...<br>No Books Available...</h3><br>");
				req.getRequestDispatcher("AddCart.jsp").forward(req, res);
				return;
					}
		req.setAttribute("msg", "<h3 style='color: green;'>These are the available books</h3><br>");
		req.getRequestDispatcher("ViewCart.jsp").forward(req, res);
		
	}
	
}
