package com.arief.hibernate.dao.impl;

import com.arief.hibernate.dao.OwnerDAO;
import com.arief.hibernate.entity.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.logging.Logger;

public class OwnerDAOImpl implements OwnerDAO {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(OwnerDAOImpl.class.getName());

    public OwnerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Owner o){
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            LOGGER.info("commited transaction  for save_owner");
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction for save_owner");
            ex.printStackTrace();
        }finally {
            session.close();
            LOGGER.info("session close for save_owner");
        }
    }

    public List<Owner> getOwners() throws Exception{
        Session session = sessionFactory.openSession();
        List<Owner> ownerList = (List<Owner>)session.createQuery("from Owner").list();
        session.close();
        return ownerList;
    }

    public void delete(Owner o){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            LOGGER.info("committed transaction  for delete_owner");
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction  for delete_owner");
            ex.printStackTrace();
        }finally {
            session.close();
            LOGGER.info("session close  for delete_owner");
        }
    }

    public void update(Owner o){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            LOGGER.info("committed transaction  for delete_owner");
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("transaction rollback  for delete_owner");
            ex.printStackTrace();
        }finally {
            session.close();
            LOGGER.info("session close  for update_owner");
        }
    }

    public Owner getOwner(String ownerId) {
        Session session = sessionFactory.openSession();
        Owner o = session.get(Owner.class,ownerId);
        session.close();
        return o;
    }
}
