package com.arief.hibernate.config;

import java.util.Properties;

public class HibernateConfiguration {

    private static Properties hibernateProperties(){
        Properties properties = new Properties();

        properties.put("hibernate.connection.url","jdbc:mysql://localhost:3306/orm_db4");
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL57Dialect");
        properties.put("hibernate.connection.username","arief");
        properties.put("hibernate.connection.password","arief");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
        properties.put("hibernate.hbm2ddl.auto","update");

        return properties;
    }

    public static Properties getHibernateProperties(){
        return hibernateProperties();
    }
}
