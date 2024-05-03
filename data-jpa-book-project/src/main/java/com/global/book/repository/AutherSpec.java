package com.global.book.repository;

import com.global.book.entity.Auther;
import com.global.book.entity.AutherSearch;
import com.global.book.entity.Book;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AutherSpec implements Specification<Auther> {
    private AutherSearch search;

    public AutherSpec(AutherSearch search) {
        super();
        this.search = search;
    }

    @Override
    public Predicate toPredicate(Root<Auther> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate>predicates=new ArrayList<>();
        //same name of the property which called books
       Join<Auther, Book> bookJoin = root.join("books", JoinType.LEFT);
        //auther name
       if(search.getAutherName() !=null && !search.getAutherName().isEmpty()) {
           predicates.add(cb.like(root.get("name"), search.getAutherName()));
       }
       //email
        if(search.getEmail() !=null && !search.getEmail().isEmpty()) {
            predicates.add(cb.like(root.get("email"), search.getEmail()));
        }
        if(search.getIpAddress() !=null && !search.getIpAddress().isEmpty()) {
            predicates.add(cb.like(root.get("ipAddress"),"%" +search.getIpAddress()+"%"));
        }
        if(search.getBookName() !=null && !search.getBookName().isEmpty()) {
            predicates.add(cb.like(bookJoin.get("name"),search.getBookName()));
        }
        if(search.getPrice()!= null) {
            predicates.add(cb.greaterThanOrEqualTo(bookJoin.get("price"),"%"+search.getPrice()+"%"));
        }

        return cb.and(predicates.toArray(new Predicate[0]));

    }
}
