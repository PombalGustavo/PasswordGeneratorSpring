package com.pombalGustavo.Password_Generator.exception;

import java.io.Serial;

public class PasswordException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PasswordException(String message) {
        super(message);
    }
}
