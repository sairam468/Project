package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userReg")
public class UserRegisterServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        UserBean ub = new UserBean();
        ub.setuName(req.getParameter("uname"));
        ub.setpWord(req.getParameter("pword"));
        ub.setfName(req.getParameter("fname"));
        ub.setlName(req.getParameter("lname"));
        ub.setAddr(req.getParameter("addr"));
        ub.setmId(req.getParameter("mid"));
        ub.setPhNo(Long.parseLong(req.getParameter("phno")));
        
        int k = new UserRegisterDAO().userRegister(ub);

        if (k > 0) {
            req.setAttribute("msg","<h3 style='color: green;'>User Registered Successfully...</h3>");
        } else {
        	 req.setAttribute("msg","<h3 style='color: red;'>User Registration error...</h3>");
        }
    
        req.getRequestDispatcher("UserRegister.jsp").include(req, res);

    }
}
