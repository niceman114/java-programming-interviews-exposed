package com.wiley.javainterviewsexposed.chapter13;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String now = new Date().toString();

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        final String responseString = String.format("<html>" +
                "<head>" +
                "<title>Time</title>" +
                "</head>" +
                "<body>The time is %s</body>" +
                "</html>", now);

        response.getWriter().print(responseString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
