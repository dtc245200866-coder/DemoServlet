package com.codegym;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet mẫu chạy trên Jakarta Servlet API (Tomcat 10.1+).
 * Truy cập tại: /hello
 */
@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"vi\">");
            out.println("<head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <title>Hello Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <h1>Hello Servlet! 👋</h1>");
            out.println("    <p>Servlet này chạy trên Jakarta Servlet API (Tomcat 10.1+).</p>");
            out.println("    <a href=\"index.jsp\">← Về trang chủ</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
