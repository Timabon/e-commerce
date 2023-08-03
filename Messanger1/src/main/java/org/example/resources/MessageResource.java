package org.example.resources;

import org.example.model.Message;
import org.example.services.MessageService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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







}
