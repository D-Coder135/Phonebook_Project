package com.dev.phonebook.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ChangeThemeServlet", value = "/theme")
public class ChangeThemeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String theme = request.getParameter("name");
        List<String> list = Arrays.asList("yeti", "united", "dark", "pulse", "cyborg");

        if (!list.contains(theme)) {
            theme = "yeti";
        }

        Cookie c1 = new Cookie("theme", theme);
        c1.setMaxAge(365 * 24 * 60 * 60);
        response.addCookie(c1);
        response.sendRedirect("./");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
