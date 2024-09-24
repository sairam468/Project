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
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        Cookie c[] = req.getCookies();
        if (c != null && c.length > 0) {
            c[0].setMaxAge(0); // Delete cookie
            res.addCookie(c[0]);
        }

        ServletContext sct = this.getServletContext();
        sct.removeAttribute("ub"); // Invalidate user session

        pw.println("<h3>You have been logged out successfully!</h3>");
        RequestDispatcher rd = req.getRequestDispatcher("login.html");
        rd.include(req, res);
    }
}
