package test;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewBooksServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession(false);
		if(hs==null) {
			request.setAttribute("msg", "<h3 style='color: red;'>Session Expired...</h3><br>");
			request.getRequestDispatcher("Msg.jsp").forward(request, response);;
		}
		else {
			@SuppressWarnings("unchecked")
			ArrayList<BookBean> all=(ArrayList<BookBean>)hs.getAttribute("al");
			if(all==null) {
				ArrayList<BookBean> al=new ViewBooksDAO().getBookDetails();
				hs.setAttribute("al", al);
			}
			request.getRequestDispatcher("ViewBooks.jsp").forward(request, response);
		}
	}
}
