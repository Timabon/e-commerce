package com.example.SpringDemo.Messanger1.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import com.example.SpringDemo.Messanger1.model.Message;
import com.example.SpringDemo.Messanger1.model.Profile;

import java.util.List;

public class HibernateTest {
    // Static variable to hold the EntityManagerFactory
    private static EntityManagerFactory entityManagerFactory;

    // Method to initialize the EntityManagerFactory
    private static void initializeEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        }
    }

    // Method to close the EntityManagerFactory
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    public static void main(String[] args) {
        initializeEntityManagerFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Message m1 = new Message("Hello Guys!", "Tymofii");
        Message m2 = new Message("Hello Girls!", "Flocki");
        Message m3 = new Message("Hello Everybody!", "Flockiss");
        Message m4 = new Message("Hello EverSSSSSybodyBoy!", "Flockiss");
        Profile p1 = new Profile("Tymofii", "Bondarchuk");
        Profile p2 = new Profile("Flocki", "Wiese");

        entityManager.getTransaction().begin();
        entityManager.persist(m1);
        entityManager.persist(m2);
        entityManager.persist(m3);
        entityManager.persist(m4);
        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public static List<Message> getAllMessages() {
        initializeEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Message> query = criteriaBuilder.createQuery(Message.class);
        Root<Message> root = query.from(Message.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public static void addMessage(Message message){
        initializeEntityManagerFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Message existingMessage = entityManager.find(Message.class, message.getMessageId());

        if (existingMessage == null) {
            entityManager.persist(message);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static void updateMessage(Message message) {
        initializeEntityManagerFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Message existingMessage = entityManager.find(Message.class, message.getMessageId());

        if (existingMessage != null) {
            entityManager.merge(message);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static Message getMessage(long messageId) {
        initializeEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Message> query = criteriaBuilder.createQuery(Message.class);
        Root<Message> root = query.from(Message.class);
        query.select(root).where(criteriaBuilder.equal(root.get("messageId"), messageId));
        return entityManager.createQuery(query).getSingleResult();
    }

    public static void delete(long id) {
        initializeEntityManagerFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Message messageToDelete = entityManager.find(Message.class, id);

        if (messageToDelete != null) {
            entityManager.remove(messageToDelete);
            return;
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
