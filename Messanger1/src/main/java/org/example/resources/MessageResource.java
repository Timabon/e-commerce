package org.example.resources;

import org.example.messages.Message;
import org.example.services.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/messages")
public class MessageResource {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessage(){
        MessageService messageService = new MessageService();
        return messageService.getAllMessages();
    }


}
