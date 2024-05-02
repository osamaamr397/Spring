package com.global.book.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.global.book.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authers")
public class Auther extends BaseEntity<Long> {
    @NotNull
    @NotEmpty()//to restrict empty char
    @NotBlank()//to restrict white spaces
    private String name;
    @Pattern(regexp = "^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$")
    private String ipAddress;

    @Email
    private String email;
  //  @NotEmpty
    @JsonBackReference
    @OneToMany(mappedBy = "auther" , cascade = CascadeType.ALL)
	private List<Book> books = new ArrayList<>();



    public List<Book> getBooks() {
        return books;
    }

    @Formula("(select count(*) from books book where book.auther_id = id)")//should put the Brackets as it is sub query
    private long bookCount;

    public void setBooks(List<Book> books) {
        this.books = books;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);
    }

    public long getBookCount() {
        return bookCount;
    }

    public void setBookCount(long bookCount) {
        this.bookCount = bookCount;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
