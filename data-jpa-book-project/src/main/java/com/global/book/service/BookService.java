package com.global.book.service;

import com.global.book.entity.Auther;
import com.global.book.entity.Book;
import com.global.book.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    private BookRepo bookRepo;
    @Autowired
    BookService(BookRepo bookRepo){
        super();
        this.bookRepo=bookRepo;
    }
    public Book findById(Long id){
        return bookRepo.findById(id).orElseThrow();
    }
    public List<Book>findAll(){
        return bookRepo.findAll();
    }
    public Book insert(Book entity){
        if(entity.getId()!=null){
            throw new RuntimeException();
        }
        return bookRepo.save(entity);
    }
    public List<Book>insertAll(List<Book>entity){
        return bookRepo.saveAll(entity);
    }
    public Book update(Book entity){
        Book book=findById(entity.getId());
        book.setName(entity.getName());
        return bookRepo.save(book);
    }
    public void deleteById(Long id){
        bookRepo.deleteById(id);
    }

}
