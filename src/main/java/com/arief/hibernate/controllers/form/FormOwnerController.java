package com.arief.hibernate.controllers.form;


import com.arief.hibernate.controllers.AbstractController;
import com.arief.hibernate.dao.OwnerDAO;
import com.arief.hibernate.dao.PetDAO;
import com.arief.hibernate.entity.Owner;
import com.arief.hibernate.entity.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/form/owner"},name = "FormOwnerServlet")
public class FormOwnerController extends AbstractController{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestDispatchForJSPFileForward("/WEB-INF/views/form-owner",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ownerId = req.getParameter("owner_id");
        String ownerName = req.getParameter("owner_name");
        String ownerAddress = req.getParameter("owner_address");
        int petId = Integer.parseInt(req.getParameter("owner_pet"));

        PetDAO petDAO = (PetDAO)getServletContext().getAttribute("petDAO");
        Pet findOne = petDAO.getOne(petId);

        OwnerDAO ownerDAO = (OwnerDAO)getServletContext().getAttribute("ownerDAO");

        Owner o = new Owner();
        o.setOwnerId(ownerId);
        o.setOwnerName(ownerName);
        o.setOwnerAddress(ownerAddress);
        o.setPet(findOne);

        ownerDAO.save(o);

        sendRedirectToContextPath(resp);
    }
}
