package org.colpix.exception;

public class ErrorCreateEntityException extends RuntimeException {

    public final String name;

    public ErrorCreateEntityException(String name) {
        this.name = name;
    }
}
