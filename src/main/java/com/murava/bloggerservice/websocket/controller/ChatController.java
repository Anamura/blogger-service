package com.murava.bloggerservice.websocket.controller;

import com.murava.bloggerservice.model.requestdata.Response;
import com.murava.bloggerservice.model.requestdata.User;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.murava.bloggerservice.model.requestdata.Message;
import com.murava.bloggerservice.model.requestdata.OutputMessage;

/**
 * Chat controller that listens to chat topic and
 * responds with a {@link OutputMessage}
 */
@Controller
public class ChatController {

    @MessageMapping("/chat/{capturedTemplateVariable}")
    @SendTo("/topic/messages")
    public OutputMessage send(@DestinationVariable("capturedTemplateVariable") final String capturedTemplateVariable,
                              final Message message) {
        return new OutputMessage(message.getFrom(), message.getText(), capturedTemplateVariable);
    }

    @MessageMapping("/user")
    @SendTo("/topic/user")
    public Response getUser(User user) {
        Response response = new Response();
        response.setContent("Hello: "+user.getName());
        return response;
    }
}
