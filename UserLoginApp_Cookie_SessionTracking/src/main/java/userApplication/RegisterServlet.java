package userApplication;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        // Populate UserBean with request data
        UserBean ub = new UserBean();
        ub.setName(req.getParameter("uname"));
        ub.setPword(req.getParameter("pword"));
        ub.setFname(req.getParameter("fname"));
        ub.setLname(req.getParameter("lname"));
        ub.setAddr(req.getParameter("addr"));
        ub.setMid(req.getParameter("mid"));
        ub.setPnum(Long.parseLong(req.getParameter("phno")));

        // Insert into DB using DAO
        int k = new RegisterDAO().insertUserDetails(ub);

        if (k > 0) {
            pw.println("<h3 style='color:green;'>User Registered Successfully!</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
        } else {
            pw.println("<h3 style='color:red;'>Error Occurred during Registration!</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("register.html");
            rd.include(req, res);
        }
    }
}
