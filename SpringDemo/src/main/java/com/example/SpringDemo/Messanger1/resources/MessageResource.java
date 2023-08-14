package com.example.SpringDemo.Messanger1.resources;
import com.example.SpringDemo.Messanger1.model.Message;
import com.example.SpringDemo.Messanger1.model.Profile;
import com.example.SpringDemo.Messanger1.services.MessageService;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;



@RestController
@RequestMapping("/messages")
public class MessageResource {
    MessageService messageService = new MessageService();

    @GetMapping
    @ResponseBody
    public List<Message> getAllMessages(){
        MessageService messageService = new MessageService();
        return messageService.getAllMessages();
    }

    @GetMapping("/{messageId}")
    @ResponseBody
    public String test(@PathVariable("messageId") Long id) {
        return String.valueOf(messageService.getMessage(id));
    }


    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseBody
    public Message addMessage(@RequestBody Message message){
        return messageService.addMessage(message);
    }

    @PutMapping("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseBody
    public Message updateMessage(@PathVariable("messageId") Long id,@RequestBody Message message){
        message.setMessageId(Math.toIntExact(id));
        return messageService.updateMessage(message);
    }

    /*@DeleteMapping("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMessage(@PathVariable long messageId) {
        Message deletedMessage = messageService.deleteMessage(messageId);
        if (deletedMessage != null) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }*/


}
