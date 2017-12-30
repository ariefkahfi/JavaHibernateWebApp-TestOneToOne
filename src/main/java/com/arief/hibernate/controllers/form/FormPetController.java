package com.arief.hibernate.controllers.form;

import com.arief.hibernate.controllers.AbstractController;
import com.arief.hibernate.dao.PetDAO;
import com.arief.hibernate.entity.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/form/pet"},name = "FormPetServlet")
public class FormPetController extends AbstractController{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestDispatchForJSPFileForward(
                "/WEB-INF/views/form-pet",
                req,
                resp
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String petCategory = req.getParameter("pet_category");
        String petName = req.getParameter("pet_name");

        PetDAO petDAO = (PetDAO)getServletContext().getAttribute("petDAO");

        Pet p  =new Pet();
        p.setPetName(petName);
        p.setPetCategory(petCategory);

        petDAO.save(p);

        sendRedirectToContextPath(resp);
    }
}
