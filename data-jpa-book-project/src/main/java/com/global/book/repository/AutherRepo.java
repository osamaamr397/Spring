package com.global.book.repository;

import com.global.book.entity.Auther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutherRepo extends JpaRepository<Auther, Long> {
    Optional<Auther> findById(Long id) ;



}
