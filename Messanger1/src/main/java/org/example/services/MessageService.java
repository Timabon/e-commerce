package org.example.services;


import org.example.hibernate.HibernateTest;
import org.example.model.Message;

import java.util.List;

public class MessageService {

    public List<Message> getAllMessages(){

      return HibernateTest.getAllMessages();
    }

    public Message getMessage(long id){
        return HibernateTest.getMessage(id);
    }

    public Message updateMessage(Message message){
        HibernateTest.updateMessage(message);
        return message;
    }

    public void deleteMessage(long id){
        HibernateTest.delete(id);;
    }
    public Message addMessage(Message message){
        HibernateTest.addMessage(message);
        return message;
    }



}
