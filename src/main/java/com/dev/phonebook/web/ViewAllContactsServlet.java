package com.dev.phonebook.web;

import com.dev.phonebook.entity.User;
import com.dev.phonebook.service.ContactService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ViewAllContactsServlet", value = "/view-all-contacts")
public class ViewAllContactsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        ContactService service = new ContactService();
        request.setAttribute("contacts", service.getAllContacts(user.getId()));
        request.getRequestDispatcher("/WEB-INF/views/show-contacts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
