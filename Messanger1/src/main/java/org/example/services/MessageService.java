package org.example.services;


import org.example.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    public List<Message> getAllMessages(){
        Message m1 = new Message("Hello Guys!", "Tymofii");
        Message m2 = new Message("Hello Girls!", "Flocki");
        Message m3 = new Message("Hello Everybody!", "Flockiss");
        List<Message> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        return list;
    }

  /*  public Message addMessage(Message message){
        HibernateTest.parsing(message);
        return message;
    }

    public Message updateMessage(Message message){
        if(message.getId() <= 0){
            return null;
        }
        HibernateTest.parsing(message);
        return message;
    }
*/

}
