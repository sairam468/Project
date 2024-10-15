package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add")
public class AddBookServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			BookBean bb=new BookBean();
			bb.setName(req.getParameter("bname"));
			bb.setAuthor(req.getParameter("bauthor"));
			bb.setCode(req.getParameter("bcode"));
			bb.setPrice(Float.parseFloat(req.getParameter("bprice")));
			bb.setQty(Integer.parseInt(req.getParameter("bqty")));
			
			int k=new AddBookDAO().AddBook(bb);

			if(k>0) {
				req.setAttribute("msg","BookDetails Added Sucessfully...<br>");
				req.getRequestDispatcher("UpdateBook.jsp").forward(req, res);
				
			}
		}

	}

}
