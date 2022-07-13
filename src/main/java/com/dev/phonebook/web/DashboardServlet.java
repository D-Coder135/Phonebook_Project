package com.dev.phonebook.web;

import com.dev.phonebook.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DashboardServlet", value = "/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("./");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request,response);
    }
}
