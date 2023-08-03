package org.example.resources;

import org.example.hibernate.HibernateTest;
import org.example.model.Message;
import org.example.services.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;



@Path("/user")
public class MessageResource {


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessages(){
        MessageService messageService = new MessageService();
        return messageService.getAllMessages();
    }

    /*public Message getMessage(long id){

        return message;
    }*/
    public Message addMessage(Message message){
        HibernateTest.parsing(message);
        return message;
    }
    @PUT
    public Message updateMessage(Message message){
        HibernateTest.parsing(message);
        return message;
    }

    public void deleteMessage(Message message){
        HibernateTest.delete(message);;
    }





}
