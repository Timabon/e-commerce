package org.example.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.model.Message;
import org.example.model.Profile;

public class HibernateTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        Message m1 = new Message("Hello Guys!", "Tymofii");
        Message m2 = new Message("Hello Girls!", "Flocki");
        Message m3 = new Message("Hello Everybody!", "Flockiss");
        Profile p1 = new Profile("Tymofii", "Bondarchuk");
        Profile p2 = new Profile("Flocki", "Wiese");


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(m1);
        entityManager.persist(m2);
        entityManager.persist(m3);
        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }



    public static void parsing(Message message){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Message existingMessage = entityManager.find(Message.class, message.getId());

        if(existingMessage == null){
            entityManager.persist(message);
        }else{
            entityManager.merge(message);
        }

        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }

    public static void delete(Message message){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Message messageToDelete = entityManager.find(Message.class, message.getId());

        if(messageToDelete != null){
            entityManager.remove(messageToDelete);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }





}
