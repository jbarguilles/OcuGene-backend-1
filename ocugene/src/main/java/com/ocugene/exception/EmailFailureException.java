package com.ocugene.exception;

/**
 * Exception to highlight that we were unable to send an email.
 */
public class EmailFailureException extends RuntimeException {

    public EmailFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
