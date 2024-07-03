package org.example.demo.controllers;

import org.example.demo.models.Hobby;
import org.example.demo.models.User;
import org.example.demo.models.dto.UserDTO;
import org.example.demo.service.HBService;
import org.example.demo.service.IHBService;
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
    IHBService hbService = new HBService();
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
        List<UserDTO> users = userService.sortByName();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/View/list.jsp").forward(req,resp);
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<UserDTO> users = userService.searchByName(keyword);
        req.setAttribute("users",users);
        req.setAttribute("keyword", keyword);
        req.getRequestDispatcher("/View/list.jsp").forward(req,resp);
    }

    private void showFormUpdateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserDTO user = userService.findUser(id);
        List<Hobby> hobbies = hbService.showAllHobby();
        req.setAttribute("user", user);
        req.setAttribute("hobbies", hobbies);
        req.getRequestDispatcher("/View/update.jsp").forward(req,resp);
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        userService.deleteUser(id);
        List<UserDTO> users = userService.selectAllUsers();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/View/list.jsp").forward(req,resp);
    }

    private void showFormCreateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hobby> hobbies = hbService.showAllHobby();
        req.setAttribute("hobbies", hobbies);
        req.getRequestDispatcher("/View/create.jsp").forward(req,resp);
    }


    private void selectAllUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDTO> users = userService.selectAllUsers();
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
        int idHobby = Integer.parseInt(req.getParameter("idHobby"));
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        user.setIdHobby(idHobby);
        userService.updateUser(user);
        resp.sendRedirect("/users/list");
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        int idHobby = Integer.parseInt(req.getParameter("idHobby"));
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        user.setIdHobby(idHobby);
        userService.createUser(user);
        resp.sendRedirect("/users/list");
    }
}
