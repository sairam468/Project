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
@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        Cookie c[] = req.getCookies();
        if (c == null) {
            pw.println("<h3 style='color:red;'>Session expired. Please log in again!</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
        } else {
            ServletContext sct = this.getServletContext();
            UserBean ub = (UserBean) sct.getAttribute("ub");

            pw.println("<h2>Edit Profile for " + ub.getFname() + "</h2>");
            pw.println("<form action='update' method='post'>");
            pw.println("Address: <input type='text' name='addr' value='" + ub.getAddr() + "'><br>");
            pw.println("Email: <input type='email' name='mid' value='" + ub.getMid() + "'><br>");
            pw.println("Phone: <input type='text' name='phno' value='" + ub.getPnum() + "' pattern='\\d{10}'><br>");
            pw.println("<input type='submit' value='Update'>");
            pw.println("</form>");
        }
    }
}
