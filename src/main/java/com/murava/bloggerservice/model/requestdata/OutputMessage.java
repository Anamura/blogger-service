package com.murava.bloggerservice.model.requestdata;

import lombok.Data;

import java.time.LocalDate;

/**
 * Output message sent to the client.
 */
@Data
public class OutputMessage {

    private final String from;
    private final String message;
    private final String capturedTemplateVariable;

    private LocalDate time = LocalDate.now();
}
