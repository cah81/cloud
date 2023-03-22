package com.book.controller;

import com.book.entity.Book;
import com.netflix.discovery.converters.Auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {
    @Autowired
    Environment environment;

    @GetMapping("/data")
    public String getBookData(){
       return "data of BOOK-SERVICE, Running on port: " + environment.getProperty("local.server.port");
    }
    @GetMapping("/all")
    public List<Book> getall(){
        return List.of(
                new Book(501,"Head First Java",439.75),
                new Book(502,"Spring in action",340.75),
                new Book(503,"Hibernate in action",355.75)
        );

    }

    @GetMapping("/entity")
    public ResponseEntity<String> getEntityData(){
        return new ResponseEntity<String>("Hello from BookRestController", HttpStatus.OK);
    }

}
