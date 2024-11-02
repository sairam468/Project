package test;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateBook")
public class UpdateCartBook extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "<h3 style='color: red;'>Session Expired....Try again....</h3><br>");
			req.getRequestDispatcher("userRegister.jsp").forward(req, res);
			return;
		}
		String bCode=(String)req.getParameter("bcode");
		String action=(String)req.getParameter("updation");
		ArrayList<AddCartBean> acb = (ArrayList<AddCartBean>) hs.getAttribute("acb");
		for (AddCartBean acbean : acb) {
			if (bCode.equals(acbean.getCode().trim())) {
				int qty=acbean.getNoOfBooks();
				if(action.equals("1")) {
					if(qty<acbean.getQty()) {
						qty++;
						acbean.setNoOfBooks(qty);
						req.setAttribute("msg"," <h3 style='color:green;'>One Book added with code "+bCode +"to the cart....</h3><br>");
					}
					else {
						req.setAttribute("msg", "<h3 style='color:red;'>Maximum Books reached with code " +bCode +" that are "+acbean.getQty()+"<br></h3><br>");
					}
				}
				else if(action.equals("-1") ) {
					if(qty>1) {
						qty--;
						acbean.setNoOfBooks(qty);
						req.setAttribute("msg", "<h3 style='color: green;'>One Book removed with code " + bCode + " from the cart....</h3><br>");
					}
					else {
						req.setAttribute("msg","<h3 style='color: red;'>Only One Book left with code " +bCode +"left in the cart....</h3><br></h3><br>");
					}
				}
			}
		}
		hs.setAttribute("acb", acb);
		req.getRequestDispatcher("ViewCart.jsp").forward(req, res);
	}

}
