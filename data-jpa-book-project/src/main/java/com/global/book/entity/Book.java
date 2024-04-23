package com.global.book.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.global.book.base.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NamedEntityGraph(name = "loadAuther",attributeNodes =@NamedAttributeNode("auther"))
@Entity
@Table(name = "books")
public class Book extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;
    @Column(name = "price")

    private double price;
    @JsonBackReference //to stop the infinity loop
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auther_id")
    private Auther auther;

    @Transient
    private double discounted;

    @Formula("(select count(*) from books)")//should put the Brackets as it is sub query
    private Long bookCount;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Auther getAuther() {
        return auther;
    }

    public void setAuther(Auther auther) {
        this.auther = auther;
    }
    public double getDiscounted() {
        return price*0.25;
    }

    public void setDiscounted(double discounted) {
        this.discounted = discounted;
    }

    public Long getBookCount() {
        return bookCount;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }

    @PostLoad
    private void calDiscount(){
        this.setDiscounted(price*0.25);
    }

}
