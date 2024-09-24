package userApplication;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        Cookie c[] = req.getCookies();
        if (c == null) {
            pw.println("<h3 style='color:red;'>Session expired. Please log in again!</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
        } else {
            String fname = c[0].getValue();
            pw.println("<h2>Welcome " + fname + "'s Profile</h2>");

            ServletContext sct = this.getServletContext();
            UserBean ub = (UserBean) sct.getAttribute("ub");

            pw.println("<p>First Name: " + ub.getFname() + "</p>");
            pw.println("<p>Last Name: " + ub.getLname() + "</p>");
            pw.println("<p>Address: " + ub.getAddr() + "</p>");
            pw.println("<p>Email: " + ub.getMid() + "</p>");
            pw.println("<p>Phone Number: " + ub.getPnum() + "</p>");
            pw.println("<a href='edit'>Edit Profile</a> | <a href='logout'>Logout</a>");
        }
    }
}
