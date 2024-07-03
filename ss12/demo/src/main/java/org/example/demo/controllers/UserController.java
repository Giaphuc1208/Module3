package org.example.demo.controllers;

import org.example.demo.models.User;
import org.example.demo.service.IUserService;
import org.example.demo.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="UserController", urlPatterns = "/users/*")
public class UserController extends HttpServlet {
    IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url){
            case "/list":
                selectAllUsers(req,resp);
                break;
            case "/create":
                showFormCreateUser(req,resp);
                break;
            case "/delete":
                deleteUser(req,resp);
                break;
            case "/update":
                showFormUpdateUser(req,resp);
                break;
            case "/search":
                searchByName(req,resp);
                break;
            case "/sort":
                sortByName(req,resp);
                break;
        }
    }

    private void sortByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.sortByName();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/View/list.jsp").forward(req,resp);
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<User> users = userService.searchByName(keyword);
        req.setAttribute("users",users);
        req.setAttribute("keyword", keyword);
        req.getRequestDispatcher("/View/list.jsp").forward(req,resp);

    }

    private void showFormUpdateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.findUser(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/View/update.jsp").forward(req,resp);
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        userService.deleteUser(id);
        List<User> users = userService.selectAllUsers();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/View/list.jsp").forward(req,resp);
    }

    private void showFormCreateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/View/create.jsp").forward(req,resp);
    }


    private void selectAllUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.selectAllUsers();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/View/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url){
            case "/create":
              createUser(req,resp);
              break;
            case "/update":
                updateUser(req,resp);
                break;
        }
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        userService.updateUser(user);
        resp.sendRedirect("/users/list");
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        userService.createUser(user);
        resp.sendRedirect("/users/list");
    }
}
