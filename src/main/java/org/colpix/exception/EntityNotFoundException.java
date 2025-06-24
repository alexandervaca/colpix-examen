package org.colpix.exception;

public class EntityNotFoundException extends RuntimeException {
    
    public final String name;

    public EntityNotFoundException(String name) {
        this.name = name;
    }
}
