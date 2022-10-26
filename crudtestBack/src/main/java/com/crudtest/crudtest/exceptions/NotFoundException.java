package com.crudtest.crudtest.exceptions;

/**
 * Created by Hai on 24-10-2022.
 */
public class NotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 6547754850676794777L;
    private static final String DESCRIPTION = "Not Found Exception (404)";

    public NotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
