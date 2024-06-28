package org.example.product_discount_calculator;

import org.example.product_discount_calculator.service.DiscountService;
import org.example.product_discount_calculator.service.IDiscountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    IDiscountService discountService = new DiscountService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/discount.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String product_description = req.getParameter("product_description");
        double list_price = Double.parseDouble(req.getParameter("list_price"));
        double discount_percent = Double.parseDouble(req.getParameter("discount_percent"));
        double discount_amount = discountService.discountAmount(list_price, discount_percent);
        double discount_price = discountService.discountAmountAfter(discount_amount, list_price);
        req.setAttribute("lp",list_price);
        req.setAttribute("pd",product_description);
        req.setAttribute("dp",discount_price);
        req.setAttribute("dm",discount_amount);
        req.getRequestDispatcher("/display.jsp").forward(req, resp);
    }
}
