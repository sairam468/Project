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
@WebServlet("/buyAllBooks")
public class CartBooksBuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession hs = req.getSession(false);

        if (hs == null) {
            req.setAttribute("msg", "<h3 style='color: red;'>Session Expired....Try again....</h3><br>");
            req.getRequestDispatcher("userRegister.jsp").forward(req, res);
            return;
        }

        // Retrieve order details from the request
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String zipcode = req.getParameter("zipcode");
        String country = req.getParameter("country");
        String paymentType = req.getParameter("paymentType");
        String cardNumber = req.getParameter("cardNumber");

        // Check if required fields are present
        if (name == null || address == null || city == null || state == null || zipcode == null || country == null || paymentType == null) {
            req.setAttribute("msg", "<h3 style='color: red;'>Missing order details....Try again....</h3><br>");
            req.getRequestDispatcher("OrderAddress.jsp").forward(req, res);
            return;
        }

        ArrayList<BookBean> al = (ArrayList<BookBean>) hs.getAttribute("al");
        ArrayList<AddCartBean> acb = (ArrayList<AddCartBean>) hs.getAttribute("acb");

        if (acb == null || acb.isEmpty()) {
            req.setAttribute("msg", "<h3 style='color: red;'>Your cart is empty....Add some books first....</h3><br>");
            req.getRequestDispatcher("UserViewBooks.jsp").forward(req, res);
            return;
        }

        int size = acb.size();
        int i = 0, k;

        for (AddCartBean acbean : acb) {
            // Purchase the books
            k = new CartBooksBuyDAO().buyBooks(acbean);
            if (k == 1) {
                i++;

                // Update the book quantities
                for (BookBean bbean : al) {
                    if (acbean.getCode().equals(bbean.getCode())) {
                        Integer Q = bbean.getQty() - acbean.getNoOfBooks();
                        bbean.setQty(Q);
                    }
                }
            }
        }

        // Check if all books were purchased successfully
        if (size == i) {
            hs.setAttribute("al", al);
            hs.removeAttribute("acb");

            // Set a success message along with order details
            String successMessage = String.format(
                    "<h3 style='color: green;'>Books Purchased Successfully...</h3><br>" +
                    "<p>Order Details:</p>" +
                    "<p>Name: %s</p>" +
                    "<p>Address: %s, %s, %s, %s, %s</p>" +
                    "<p>Payment Type: %s</p>",
                    name, address, city, state, zipcode, country, paymentType
            );
            req.setAttribute("msg", successMessage);
        } else {
            req.setAttribute("msg", "<h3 style='color: red;'>Error Purchasing Books...</h3><br>");
        }

        req.getRequestDispatcher("orderSucessfull.jsp").forward(req, res);
    }
}
