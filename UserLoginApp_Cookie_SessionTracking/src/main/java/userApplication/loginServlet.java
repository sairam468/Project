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
@WebServlet("/log")
public class loginServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        // Authenticate user
        UserBean ub = new LoginDAO().login(req);

        if (ub == null) {
            pw.println("<h3 style='color:red;'>Invalid Login Credentials!</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
        } else {
            // Set user session attribute and add a cookie
            ServletContext sct = this.getServletContext();
            sct.setAttribute("ub", ub);
            Cookie ck = new Cookie("fname", ub.getFname());
            res.addCookie(ck);

            // Redirect to dashboard (link.html)
            RequestDispatcher rd = req.getRequestDispatcher("link.html");
            rd.include(req, res);
        }
    }
}
