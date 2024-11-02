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
@WebServlet("/buy")
public class BooksBuyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	 
        HttpSession hs = req.getSession(false);
        if (hs == null) {
            req.setAttribute("msg","<h3 style='color: red;'>Session Expired...</h3><br>");
            req.getRequestDispatcher("userRegister.jsp").forward(req, res);
            return;
        } else {
            String bCode = req.getParameter("bcode").trim();

            ArrayList<BookBean> al = (ArrayList<BookBean>) hs.getAttribute("al");
            Iterator<BookBean> i = al.iterator();
            while (i.hasNext()) {
                BookBean bb = i.next();
                if (bCode.equals(bb.getCode().trim())) {
                    req.getRequestDispatcher("BooksBuy.jsp").forward(req, res);
                    return; 
                }
            }
            req.getRequestDispatcher("UserViewBooks.jsp").forward(req, res);
        }
    }
}
