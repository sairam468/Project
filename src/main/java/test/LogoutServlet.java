package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession hs=request.getSession(false);
		if(hs==null) {
			request.setAttribute("msg", "Session expired...<br>");
			
		}
		else {	
	
			hs.removeAttribute("abean"); //optional
			hs.removeAttribute("al");
			
			hs.invalidate();
			request.setAttribute("msg", "Logged out Sucessfully...<br>");
	
	}
		request.getRequestDispatcher("Msg.jsp").forward(request, response);

}
}
