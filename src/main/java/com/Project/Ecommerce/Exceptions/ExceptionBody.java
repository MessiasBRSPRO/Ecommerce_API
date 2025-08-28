package com.Project.Ecommerce.Exceptions;

import java.time.Instant;

public class ExceptionBody {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public ExceptionBody(Instant timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
