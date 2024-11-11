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
@WebServlet("/update")
public class UpdateBookServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "<h3 style='color: red;'>Session Expired...</h3><br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String bCode=req.getParameter("bcode");
			float bprice=Float.parseFloat(req.getParameter("bprice"));
			int bQty=Integer.parseInt(req.getParameter("bqty"));

			ArrayList<BookBean> al=(ArrayList<BookBean>)hs.getAttribute("al");
			Iterator<BookBean> i=al.iterator();
			while(i.hasNext()) {
				BookBean b=(BookBean)i.next();
				if(bCode.equals(b.getCode())) {
					b.setPrice(bprice);
					b.setQty(bQty);
					int k=new UpdateBookDAO().UpdateBook(b);
					if(k>0) {
						hs.setAttribute("al", al);
						req.setAttribute( "msg","<h3 style='color: green;'>Book Updated Sucessfully........</h3><br>" );
						req.getRequestDispatcher("ViewBooks.jsp").forward(req, res);
					}	
					break;
				}
			}
		}
	}
}
