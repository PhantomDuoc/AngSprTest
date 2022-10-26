package com.crudtest.crudtest.exceptions;

/**
 * Created by Hai on 24-10-2022.
 */
public class BadRequestException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -8168794214579908279L;
    private static final String DESCRIPTION = "Bad Request Exception (400)";

    public BadRequestException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
