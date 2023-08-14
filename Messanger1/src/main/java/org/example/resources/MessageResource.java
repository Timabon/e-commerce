package org.example.resources;

import org.example.model.Message;
import org.example.services.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;



@Path("/user")
public class MessageResource {
    MessageService messageService = new MessageService();

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessages(){
        MessageService messageService = new MessageService();
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String test(@PathParam("messageId") long id){
        return String.valueOf(messageService.getMessage(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message){
        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long id, Message message){
        message.setMessageId((int) id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMessage(@PathParam("messageId") long id){
        return Response.ok().build();
    }

}
