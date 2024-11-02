package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet("/removeBook")
public class removeCartBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession hs = req.getSession(false);
        if (hs == null) {
            req.setAttribute("msg", "<h3 style='color: red;'>Session Expired....Try again....</h3><br>");
            req.getRequestDispatcher("userRegister.jsp").forward(req, res);
            return;
        }
        
        String bCode = req.getParameter("bcode");
        ArrayList<AddCartBean> acb = (ArrayList<AddCartBean>) hs.getAttribute("acb");
        
        if (acb != null) {
            Iterator<AddCartBean> iterator = acb.iterator();
            boolean bookRemoved = false;
            
            while (iterator.hasNext()) {
                AddCartBean acbean = iterator.next();
                if (bCode.equals(acbean.getCode().trim())) {
                    iterator.remove(); // Safely remove the element using the iterator
                    bookRemoved = true;
                    break; // Exit the loop once the book is removed
                }
            }
            
            hs.setAttribute("acb", acb);
            if (bookRemoved) {
                req.setAttribute("msg", "<h3 style='color: green;'>Book with code " + bCode + " Removed from the cart....</h3><br>");
            } else {
                req.setAttribute("msg", "<h3 style='color: red;'>Book with code " + bCode + " not found in the cart....</h3><br>");
            }
            req.getRequestDispatcher("ViewCart.jsp").forward(req, res);
        } else {
            req.setAttribute("msg", "<h3 style='color: red;'>No items in the cart....</h3><br>");
            req.getRequestDispatcher("ViewCart.jsp").forward(req, res);
        }
    }
}
