package com.arief.hibernate.controllers.delete;

import com.arief.hibernate.controllers.AbstractController;
import com.arief.hibernate.dao.OwnerDAO;
import com.arief.hibernate.entity.Owner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/owner/delete/*"},name = "OwnerDeleteServlet")
public class OwnerController extends AbstractController{

    private static final Logger LOGGER = Logger.getLogger(OwnerController.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String ownerId = pathInfo.substring(1,pathInfo.length());

        LOGGER.info("incoming request from client .....");

        LOGGER.info("Owner ID : " + ownerId);

        OwnerDAO ownerDAO = (OwnerDAO)getServletContext().getAttribute("ownerDAO");
        Owner o = ownerDAO.getOwner(ownerId);
        ownerDAO.delete(o);


        sendRedirectToContextPath(resp);
    }
}
