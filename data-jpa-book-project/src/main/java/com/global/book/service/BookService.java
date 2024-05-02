package com.global.book.service;

import com.global.book.base.BaseService;
import com.global.book.entity.Auther;
import com.global.book.entity.Book;
import com.global.book.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService extends BaseService<Book,Long> {

    private BookRepo bookRepo;
    @Autowired
    BookService(BookRepo bookRepo){
        super();
        this.bookRepo=bookRepo;
    }

    public List<Book>insertAll(List<Book>entity){
        return bookRepo.saveAll(entity);
    }
    public Book update(Book entity){
        Book book=findById(entity.getId());
        book.setName(entity.getName());
        return update(entity);
    }
    public int deleteByAuthorId(Long id){
        return bookRepo.deleteByAuthorId(id);

    }

}
