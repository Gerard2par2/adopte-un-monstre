package com.simard.adopteunmonstre.exception;

public class DuplicatedEntryException extends RuntimeException{
    public DuplicatedEntryException(String message) {
        super(message);
    }
}
