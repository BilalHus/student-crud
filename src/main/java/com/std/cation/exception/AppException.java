package com.std.cation.exception;

import org.springframework.http.HttpStatus;

public abstract class AppException extends RuntimeException {

    public abstract String getMessage();

    public abstract HttpStatus getStatus();
}
