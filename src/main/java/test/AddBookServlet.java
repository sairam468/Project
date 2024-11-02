package test;

import java.io.IOException;
import java.util.ArrayList;

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
			req.setAttribute("msg","<h3 style='color: red;'>Session Expired...</h3><br>");
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
				ArrayList<BookBean> al=(ArrayList<BookBean>)hs.getAttribute("al");
				al.add(bb);
				hs.setAttribute("al", al);
				req.setAttribute("msg","<h3 style='color: green;'>BookDetails Added Sucessfully...</h3><br>" );
				req.getRequestDispatcher("ViewBooks.jsp").forward(req, res);
							}
			else {
				req.setAttribute("msg","<h3 style='color: red;'>Error Adding book details...</h3><br>");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
				
			}
		}

	}

}
