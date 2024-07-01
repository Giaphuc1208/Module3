package org.example.demo.controllers;

import org.example.demo.model.Student;
import org.example.demo.services.IStudentService;
import org.example.demo.services.Impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name="StudentControllers",value = "/student")
public class StudentControllers extends HttpServlet {
    private static final IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/student/create.jsp").forward(req, resp);
            case "update":
                Long id = Long.parseLong(req.getParameter("id"));
                Student student = studentService.findById(id);
                req.setAttribute("students", student);
                req.getRequestDispatcher("/student/update.jsp").forward(req, resp);
                break;
            default:
                List<Student> students = studentService.findAll();
                req.setAttribute("students", students);
                req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String name = req.getParameter("name");
                String address = req.getParameter("address");
                Float points = Float.parseFloat(req.getParameter("point"));
                Student student = new Student(name, address, points);
                studentService.save(student);
                resp.sendRedirect("/student");
            case "delete":
                Long id = Long.parseLong(req.getParameter("id"));
                Boolean isDelete = studentService.deleteById(id);
                if(isDelete) {
                    resp.sendRedirect("/student");
                } else {
                    req.setAttribute("message", "Xóa không thành công");
                    List<Student> students = studentService.findAll();
                    req.setAttribute("students", students);
                    req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
                }
            case "update":
                Long input = Long.parseLong(req.getParameter("id"));
                String nameUpdate = req.getParameter("name");
                String addressUpdate = req.getParameter("address");
                Float pointsUpdate = Float.parseFloat(req.getParameter("point"));

                Student studentUpdate = studentService.findById(input);

                studentUpdate.setName(nameUpdate);
                studentUpdate.setAddress(addressUpdate);
                studentUpdate.setPoint(pointsUpdate);
                int index = studentService.findIndex(studentUpdate);
                boolean isUpdate = studentService.update(index,studentUpdate);
                if (isUpdate) {
                    req.setAttribute("message", "Cập nhật thành công");
                    List<Student> students = studentService.findAll();
                    req.setAttribute("students", students);
                    req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
                }
                break;
            case "search":
                String searchName = req.getParameter("name");
                if (Objects.equals(searchName, "")) {
                    List<Student> students = studentService.findAll();
                    req.setAttribute("students", students);
                    req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
                } else {
                    List<Student> searchStudent = studentService.findByName(searchName);
                    req.setAttribute("students", searchStudent);
                    req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
                }
                break;
        }
    }
}

