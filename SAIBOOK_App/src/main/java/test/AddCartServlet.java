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
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession hs = req.getSession(false);
        ArrayList<AddCartBean> acb;
        if (hs == null) {
            req.setAttribute("msg", "<h3 style='color: red;'>Session Expired....Try again....</h3><br>");
            req.getRequestDispatcher("userRegister.jsp").forward(req, res);
            return;
        }

        acb = (ArrayList<AddCartBean>) hs.getAttribute("acb");
        if (acb == null) {
            acb = new ArrayList<AddCartBean>();
        }

        String bCode = req.getParameter("bcode");
        String numOfBookStr = req.getParameter("numOfbooks");

        if (bCode == null || bCode.trim().isEmpty() || numOfBookStr == null || numOfBookStr.trim().isEmpty()) {
            req.setAttribute("msg", "<h3 style='color: red;'>Book code or number of books is missing....Try again....</h3><br>");
            req.getRequestDispatcher("BooksBuy.jsp").forward(req, res);
            return;
        }

        bCode = bCode.trim();
        int noOfBooks;

        try {
            noOfBooks = Integer.parseInt(numOfBookStr.trim());
            if (noOfBooks <= 0) {
                throw new NumberFormatException("Number of books must be greater than zero.");
            }
        } catch (NumberFormatException e) {
            req.setAttribute("msg", "<h3 style='color: red;'>Invalid number of books. Please enter a positive integer</h3><br>");
            req.getRequestDispatcher("BooksBuy.jsp").forward(req, res);
            return;
        }

        ArrayList<BookBean> al = (ArrayList<BookBean>) hs.getAttribute("al");

        if (al == null || al.isEmpty()) {
            req.setAttribute("msg", "<h3 style='color: red;'>Error No books ...</h3><br>");
            req.getRequestDispatcher("AddCart.jsp").forward(req, res);
            return;
        }

        boolean bookFound = false;

        for (BookBean bb : al) {
            if (bCode.equals(bb.getCode().trim())) {
                bookFound = true;
                int availableQty = bb.getQty();

                if (availableQty < noOfBooks) {
                    req.setAttribute("msg", "<h3 style='color: red;'>Not enough stock available. Only " + availableQty + " books left....</h3><br>");
                    req.getRequestDispatcher("AddCart.jsp").forward(req, res);
                    return;
                }

                boolean bookInCart = false;
                for (AddCartBean acbean : acb) {
                    if (acbean.getCode().equals(bCode)) {
                        int totNumOfBooks = acbean.getNoOfBooks() + noOfBooks;
                        acbean.setNoOfBooks(totNumOfBooks);
                        bookInCart = true;
                        break;
                    }
                }

                if (!bookInCart) {
                    AddCartBean acbean = new AddCartBean();
                    acbean.setCode(bCode);
                    acbean.setName(bb.getName());
                    acbean.setAuthor(bb.getAuthor());
                    acbean.setPrice(bb.getPrice());
                    acbean.setQty(bb.getQty());
                    acbean.setNoOfBooks(noOfBooks);
                    acb.add(acbean);
                }

                hs.setAttribute("acb", acb);
                req.setAttribute("msg", "<h3 style='color: green;'>Book added to cart successfully...</h3><br>");
                break;
            }
        }

        if (!bookFound) {
            req.setAttribute("msg", "<h3 style='color: red;'>Error occurred: Book with code " + bCode + " not found.</h3><br>");
        }

        req.getRequestDispatcher("UserViewBooks.jsp").forward(req, res);
    }
}
