package com.murava.bloggerservice.websocket.controller;

import com.murava.bloggerservice.model.requestdata.Response;
import com.murava.bloggerservice.model.requestdata.User;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Chat controller that listens to topic and
 * responds.
 */
@Controller
public class ChatController {

    @MessageMapping("/user")
    @SendTo("/topic/user")
    public Response getUser(User user) {
        Response response = new Response();
        response.setContent("Hello: "+user.getName());
        return response;
    }

    @MessageMapping("/blog")
    @SendTo("/test/queue")
    public Response someUser(User user){
        Response response = new Response();
        response.setContent("Hi: "+user.getName());
        return response;
    }
}
