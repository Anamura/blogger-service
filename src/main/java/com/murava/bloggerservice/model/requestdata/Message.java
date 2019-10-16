package com.murava.bloggerservice.model.requestdata;

import lombok.Data;

/**
 * Message received from the client.
 */
@Data
public class Message {

    private final String from;
    private final String text;
}
