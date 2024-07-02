package org.example.product.controllers;

import org.example.product.model.Product;
import org.example.product.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
                break;
            case "view":
                viewProduct(req, resp);
                break;
            case "search":
                showSearchForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            default:
                listCustomers(req, resp);
                break;
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findProductById(id);
        request.setAttribute("product", product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findProductById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/view.jsp");
        dispatcher.forward(request, response);
    }


    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
            case "edit":
                updateProduct(req, resp);
                break;
            case "search":
                searchProduct(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            default:
                listCustomers(req, resp);
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 10000);
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productDescription = request.getParameter("productDescription");
        String productManufacture = request.getParameter("productManufacture");

        Product product = new Product(id, productName, productPrice, productDescription, productManufacture);
        productService.addNewProduct(product);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("productsName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productDescription = request.getParameter("productDescription");
        String productManufacture = request.getParameter("productManufacture");
        Product product = new Product(id, productName, productPrice, productDescription, productManufacture);
        productService.updateProduct(id, product);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameProduct");
        List<Product> productList = productService.searchProductByName(name);
        RequestDispatcher dispatcher;
        if (productList.size() == 0) {
            request.setAttribute("message", "không có đâu mà tìm");
        } else {
            request.setAttribute("products", productList);
        }
        dispatcher = request.getRequestDispatcher("/product/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        RequestDispatcher dispatcher;
        request.setAttribute("products", products);
        dispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
