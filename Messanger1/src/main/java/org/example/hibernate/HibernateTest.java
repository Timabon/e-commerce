package org.example.hibernate;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.messages.Message;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        Message m1 = new Message(1,"Hello Guys!", "Tymofii");
        Message m2 = new Message(2,"Hello Girls!", "Flocki");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(m1);
        entityManager.persist(m2);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();

    }
}
