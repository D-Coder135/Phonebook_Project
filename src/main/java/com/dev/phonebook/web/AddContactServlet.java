package com.dev.phonebook.web;

import com.dev.phonebook.entity.Contact;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddContactServlet", value = "/add-contact")
public class AddContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/contactForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    }
}
