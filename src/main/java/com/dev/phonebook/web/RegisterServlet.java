package com.dev.phonebook.web;

import com.dev.phonebook.entity.User;
import com.dev.phonebook.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            response.sendRedirect("./dashboard");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. read inputs from request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cPassword = request.getParameter("c_password");

        // 2. make use of a model function
        UserService service = new UserService();
        Map<String, String> errors = new HashMap<>();
        User user = service.registerUser(name, email, password, cPassword, errors);

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("./dashboard");
        }
    }
}
