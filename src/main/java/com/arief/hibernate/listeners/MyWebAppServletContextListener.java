package com.arief.hibernate.listeners;

import com.arief.hibernate.config.HibernateSetup;
import com.arief.hibernate.dao.OwnerDAO;
import com.arief.hibernate.dao.PetDAO;
import com.arief.hibernate.dao.impl.OwnerDAOImpl;
import com.arief.hibernate.dao.impl.PetDAOImpl;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

public class MyWebAppServletContextListener implements ServletContextListener {


    private static final Logger LOGGER = Logger.getLogger(MyWebAppServletContextListener.class.getName());

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        LOGGER.info("init sessionFactory in ServletContextListener");
        SessionFactory sessionFactory = HibernateSetup.sessionFactoryInstance();

        LOGGER.info("inject sessionFactory in OwnerDAO bean ...");
        OwnerDAO ownerDAO = new OwnerDAOImpl(sessionFactory);

        LOGGER.info("inject sessionFactory in PetDAO bean ....");
        PetDAO petDAO = new PetDAOImpl(sessionFactory);

        LOGGER.info("inject ownerDAO to servletContextAttribute ...");
        servletContextEvent
                .getServletContext()
                .setAttribute("ownerDAO",ownerDAO);

        LOGGER.info("inject petDAO to servletContextAttribute ...");
        servletContextEvent
                .getServletContext()
                .setAttribute("petDAO",petDAO);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("Context destroyed ...");
    }
}
