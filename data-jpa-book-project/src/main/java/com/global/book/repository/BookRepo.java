package com.global.book.repository;

import com.global.book.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    @Override
    @EntityGraph(value = "loadAuther")
    Optional<Book> findById(Long id);
   /*
    @Query("select book from Book where id = :id")
    Optional<Book>findByIdCustom(Long id);

    */
    /*
    * the above query not preferred and the preferred is the first
    * as it have been declared in the context or in the caching
    * */
    @Override
    @EntityGraph(attributePaths = {"auther"})
    List<Book> findAll();
    @Transactional
    @Modifying
    @Query("delete from Book where auther.id = :id")
    int deleteByAuthorId(Long id);
}
