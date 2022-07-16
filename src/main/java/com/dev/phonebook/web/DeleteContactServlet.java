package com.dev.phonebook.web;

import com.dev.phonebook.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteContactServlet", value = "/delete-contact")
public class DeleteContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getParameter("id");
        if (input == null) {
            response.sendRedirect("./");
            return;
        }

        Integer id = Integer.valueOf(input);
        User user = (User) request.getSession().getAttribute("user");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
