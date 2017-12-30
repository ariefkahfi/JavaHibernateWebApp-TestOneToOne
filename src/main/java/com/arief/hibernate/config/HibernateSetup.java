package com.arief.hibernate.config;

import com.arief.hibernate.entity.Owner;
import com.arief.hibernate.entity.Pet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSetup {

    private static SessionFactory setUpSessionFactory(){
        Configuration configuration = new Configuration()
                .setProperties(HibernateConfiguration.getHibernateProperties())
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(Pet.class);

        return configuration.buildSessionFactory();
    }

    public static SessionFactory sessionFactoryInstance(){
        return setUpSessionFactory();
    }
}
