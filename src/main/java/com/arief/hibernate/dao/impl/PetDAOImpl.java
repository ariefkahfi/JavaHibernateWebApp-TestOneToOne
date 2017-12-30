package com.arief.hibernate.dao.impl;

import com.arief.hibernate.dao.PetDAO;
import com.arief.hibernate.entity.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.logging.Logger;

public class PetDAOImpl implements PetDAO {

    private SessionFactory sessionFactory;
    private static final Logger LOGGER = Logger.getLogger(PetDAOImpl.class.getName());


    public PetDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Pet p) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Pet> getPets() throws Exception{
        Session session = sessionFactory.openSession();
        List<Pet> petList = (List<Pet>)session.createQuery("from Pet").list();
        session.close();
        return petList;
    }

    public void delete(Pet p) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(p);
            session.getTransaction().commit();
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }

    public Pet getOne(int petId) {
        Session session = sessionFactory.openSession();

        Pet p  = session.get(Pet.class,petId);

        session.close();
        return  p;
    }

    public void update(Pet p) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }
}
