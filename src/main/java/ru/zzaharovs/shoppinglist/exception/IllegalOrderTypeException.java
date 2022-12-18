package ru.zzaharovs.shoppinglist.exception;

public class IllegalOrderTypeException extends RuntimeException{

    public IllegalOrderTypeException(String message) {
        super(message);
    }
}
