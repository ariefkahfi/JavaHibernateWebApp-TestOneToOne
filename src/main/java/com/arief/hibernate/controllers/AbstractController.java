package com.arief.hibernate.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController extends HttpServlet{

    protected void requestDispatchForJSPFileForward(
            String pathOfJspFile ,
            HttpServletRequest request ,
            HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(pathOfJspFile+".jsp")
                .forward(request,response);
    }

    protected void sendRedirectToContextPath(HttpServletResponse response) throws IOException {
        response.sendRedirect(getServletContext().getContextPath());
    }
}
