package org.example.demo.controllers;

import org.example.demo.models.Category;
import org.example.demo.models.Product;
import org.example.demo.models.dto.ProductDTO;
import org.example.demo.repositories.category.ICategoryRepo;
import org.example.demo.services.category.CategoryService;
import org.example.demo.services.category.ICategoryService;
import org.example.demo.services.product.IProductService;
import org.example.demo.services.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {
    private static IProductService productService = new ProductService();
    private static ICategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        System.out.println(url);
        switch (url){
            case "/list":
                selectAll(req,resp);
                break;
            case "/create":
                showFormCreate(req,resp);
                break;
            case "/delete":
                deleteProduct(req,resp);
                break;
            case "/search":
                searchByName(req,resp);
                break;
            case "/update":
                showFormUpdate(req,resp);
                break;

        }
    }

    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findProductByID(id);
        List<Category> categories = categoryService.showAllCategories();
        req.setAttribute("product",product);
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/views/update.jsp").forward(req,resp);
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        System.out.println(keyword);
        List<Product> list =productService.searchByName(keyword);
        req.setAttribute("products",list);
        req.getRequestDispatcher("/views/products.jsp").forward(req,resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
        resp.sendRedirect("/product/list");

    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.showAllCategories();
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/views/create.jsp").forward(req,resp);
    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> products = productService.selectAll();
        req.setAttribute("products",products);
        req.getRequestDispatcher("/views/products.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url){
            case "/create":
            createProduct(req,resp);
                break;
            case "/update":
                updateProduct(req,resp);
                break;
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String sku = req.getParameter("sku");
        String name = req.getParameter("name");
        String unit = req.getParameter("unit");
        double price = Double.parseDouble(req.getParameter("price"));
        int id_Category = Integer.parseInt(req.getParameter("id_Category"));
        String dateReceive = req.getParameter("dateReceive");
        Product product = new Product();
        product.setId(id);
        product.setSku(sku);
        product.setName(name);
        product.setUnit(unit);
        product.setPrice(price);
        product.setId_cate(id_Category);
        product.setDateReceive(dateReceive);
        productService.updateProduct(product);
        resp.sendRedirect("/product/list");
    }


    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Product product = new Product();
        String sku = req.getParameter("sku");
        String name = req.getParameter("name");
        String unit = req.getParameter("unit");
        double price = Double.parseDouble(req.getParameter("price"));
        int id_Category = Integer.parseInt(req.getParameter("id_Category"));
        String dateReceive = req.getParameter("dateReceive");
        product.setSku(sku);
        product.setName(name);
        product.setUnit(unit);
        product.setPrice(price);
        product.setId_cate(id_Category);
        product.setDateReceive(dateReceive);
        productService.createProduct(product);
        resp.sendRedirect("/product/list");
    }
}
