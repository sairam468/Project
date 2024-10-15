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
@WebServlet("/delete")
public class DeleteBookServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);;
		}
		else {

			String bCode=(String)req.getParameter("bcode");

			ArrayList<BookBean> al=(ArrayList<BookBean>) hs.getAttribute("al");
			Iterator<BookBean> i=al.iterator();
			while(i.hasNext()) {
				BookBean bb=(BookBean)i.next();
				if(bCode.equals(bb.getCode())) {
					int k=new DeleteBookDAO().delete(bb);
					System.out.println(k);
					if(k>0) {
						al.remove(bb);
						hs.removeAttribute("al");
						hs.setAttribute("al", al);
						req.setAttribute("msg", "Book Deleted Sucessfully...<br>");
						req.getRequestDispatcher("UpdateBook.jsp").forward(req, res);

					}
					else {
						req.setAttribute("msg", "An Error Occured ...<br>");
						req.getRequestDispatcher("Msg.jsp").forward(req, res);;
					}
				}
			}
		}
	}
}
