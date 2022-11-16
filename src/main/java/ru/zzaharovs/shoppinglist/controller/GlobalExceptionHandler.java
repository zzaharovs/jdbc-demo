package ru.zzaharovs.shoppinglist.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.zzaharovs.shoppinglist.service.ShoppingListService;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleEmptyException(NullPointerException ex) {
        return new ResponseEntity<>("aassdasds", HttpStatus.NOT_FOUND);

    }

}
