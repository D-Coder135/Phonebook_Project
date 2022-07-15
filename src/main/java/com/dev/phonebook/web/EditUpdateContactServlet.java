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

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String avatar = request.getParameter("avatar");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String pincode = request.getParameter("pincode");
        String country = request.getParameter("country");

        Contact c = new Contact();
        c.setFirstname(firstname);
        c.setLastname(lastname);
        c.setEmail(email);
        c.setPhone(phone);
        c.setAvatar(avatar);
        c.setAddress(address);
        c.setCity(city);
        c.setState(state);
        c.setPincode(pincode);
        c.setCountry(country);

        User user = (User) request.getSession().getAttribute("user");
        c.setUserId(user.getId());

        ContactService service = new ContactService();
        Map<String, String> errors = new HashMap<>();
    }
}
