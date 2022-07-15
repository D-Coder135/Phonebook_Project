package com.dev.phonebook.web;

import com.dev.phonebook.entity.Contact;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "RequestToContactFilter")
public class RequestToContactFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

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

        chain.doFilter(request, response);
    }
}
