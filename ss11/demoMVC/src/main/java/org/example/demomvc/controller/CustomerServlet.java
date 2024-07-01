package org.example.demomvc.controller;

import org.example.demomvc.model.Customer;
import org.example.demomvc.service.CustomerService;
import org.example.demomvc.service.Impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = " ";
        }
        switch (action){
            case "create":
            case "edit":
            case "delete":
            case "view":
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
            case "edit":
            case "delete":
            default:
        }
    }

    private void createCustomer(HttpServletRequest req, HttpServletResponse resp){
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int id = (int) (Math.random() * 1000);

        Customer customer = new Customer(id,name,email,address);
        this.customerService.save(customer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
        req.setAttribute("message","new Customer was created");
        try{
            dispatcher.forward(req,resp);
        } catch (ServletException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
