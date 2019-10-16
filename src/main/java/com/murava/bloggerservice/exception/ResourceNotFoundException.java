package com.murava.bloggerservice.exception;

import java.io.IOException;

public class ResourceNotFoundException extends IOException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() {
        super();
    }

    /**
     * Constructor.
     *
     * @param message Return the error message.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}