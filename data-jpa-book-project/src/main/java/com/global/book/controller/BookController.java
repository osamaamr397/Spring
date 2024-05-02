package com.global.book.controller;

import com.global.book.entity.Book;
import com.global.book.entity.BookDto;
import com.global.book.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    @Autowired
    BookController(BookService bookService){
        super();
        this.bookService=bookService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @Min(value = 10) Long id){
        Book book=bookService.findById(id);
        BookDto dto=new BookDto();
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setPrice(book.getPrice());
        dto.setAuther(book.getAuther());
        return  ResponseEntity.ok(dto);
    }
    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }
    @PostMapping()
    public ResponseEntity<?> insert(@RequestBody @Valid BookDto entity){
        Book book=new Book();
        book.setName(entity.getName());
        book.setPrice(entity.getPrice());
        book.setAuther(entity.getAuther());
        return ResponseEntity.ok(bookService.insert(book));
    }
    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody @Valid BookDto entity){
        Book book=new Book();
        book.setName(entity.getName());
        book.setPrice(entity.getPrice());
        book.setAuther(entity.getAuther());
        return ResponseEntity.ok(bookService.update(book));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        bookService.deleteById(id);
        return ResponseEntity.ok(null);
    }
    @DeleteMapping("/auther/{id}")
    public ResponseEntity<?> deleteByAuthorId(@PathVariable Long id){
        return ResponseEntity.ok(bookService.deleteByAuthorId(id));
    }


}
