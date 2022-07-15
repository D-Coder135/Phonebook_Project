package com.dev.phonebook.web;

import com.dev.phonebook.entity.Contact;
import com.dev.phonebook.entity.User;
import com.dev.phonebook.service.ContactService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "EditUpdateContactServlet", value = "/edit-and-update-contact")
public class EditUpdateContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getParameter("id");
        if (input == null) {
            response.sendRedirect("./");
            return;
        }
        Integer id = Integer.valueOf(input);
        ContactService service = new ContactService();
        User user = (User) request.getSession().getAttribute("user");

        Contact contact = service.getContactById(id, user.getId());
        request.setAttribute("contact", contact);

        request.setAttribute("title", "Edit contact details");
        request.getRequestDispatcher("/WEB-INF/views/contactForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String input = request.getParameter("id");
        if (input == null) {
            response.sendRedirect("./");
            return;
        }
        Integer id = Integer.valueOf(input);



        Contact c = (Contact) request.getAttribute("contact");
        User user = (User) request.getSession().getAttribute("user");
        c.setUserId(user.getId());

        ContactService service = new ContactService();
        Map<String, String> errors = new HashMap<>();
        service.updateContact(id, c, errors);

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            request.setAttribute("contact", c);
            request.getRequestDispatcher("/WEB-INF/views/contactForm.jsp").forward(request, response);
        } else {
            response.sendRedirect("./view-contact-details?id=" + c.getId());
        }

    }
}
