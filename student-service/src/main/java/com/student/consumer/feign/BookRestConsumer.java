package com.student.consumer.feign;

import com.student.consumer.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BOOK-SERVICE")
public interface BookRestConsumer {
    @GetMapping("/book/data")
    public String getBookData();

    @GetMapping("book/book/{bookId}")
    public Book getBookById(@PathVariable Integer bookId);

    @GetMapping("book/all")
    public List<Book> getAllBooks();

    @GetMapping("/book/entity")
    public ResponseEntity<String> getEntityData();
}
