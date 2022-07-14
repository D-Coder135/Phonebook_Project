package com.dev.phonebook.web;

import com.dev.phonebook.service.ContactService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ViewContactServlet", value = "/ViewContactServlet")
public class ViewContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getParameter("id");

        if (input == null) {
            response.sendRedirect("./");
            return;
        }

        Integer id = Integer.valueOf(input);

        ContactService service = new ContactService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
