package edu.cpp.brcm.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;

public class Hibernate {
    private static SessionFactory factory;
    static {
        factory = new Configuration().configure().buildSessionFactory();
    }
    public static Session getSession(){
        return factory.openSession();
    }
}
