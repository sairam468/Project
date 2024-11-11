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


@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditBookServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg","<h3 style='color: red;'>Session Expired...</h3><br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			return; 
		}
		  
		String bCode = req.getParameter("bcode").trim();

		ArrayList<BookBean> al = (ArrayList<BookBean>) hs.getAttribute("al");

		if (al == null || bCode == null) {
			req.setAttribute("msg", "<h3 style='color: red;'>Book list is not available or invalid book code....</h3><br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			return; 
		}

		Iterator<BookBean> i = al.iterator();
		boolean found = false;

		//	        System.out.println("bCode characters:");
		//	        for (char c : bCode.toCharArray()) {
		//	            System.out.print((int) c + " ");
		//	        }
		//	        System.out.println("\nbb.getCode() characters:");
		//	        for (char c : bb.getCode().toCharArray()) {
		//	            System.out.print((int) c + " ");
		//	        }
		//	        System.out.println();
		//	        System.out.println("Comparing (trimmed): " + bCode.trim().equals(bb.getCode().trim()));
		//	        System.out.println("bCode: [" + bCode + "]");
		//	        System.out.println("bb.getCode(): [" + bb.getCode() + "]");
		//
		//	        
		//	        System.out.println(al);
		//	        System.out.println(bCode.equals(bb.getCode()));
		//	        System.out.println(bb.getCode());
		//	        System.out.println(bCode);
		//	        
		//	        if (bb.getCode() != null && bCode.equalsIgnoreCase(bb.getCode())) {
		//	            req.setAttribute("bbean", bb);
		//	            req.getRequestDispatcher("Update.jsp").forward(req, res);
		//	            found = true;
		//	            break;
		//	        }

		while (i.hasNext()) {
			BookBean bb = i.next();
			if (bCode.equals(bb.getCode().trim())) {
				req.setAttribute("bbean", bb);
				req.getRequestDispatcher("Update.jsp").forward(req, res);
				found = true;
				break;
			}
		}
			if (!found) {
			req.setAttribute("msg", "<h3 style='color: red;'>Book not found.....</h3><br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	}
}

