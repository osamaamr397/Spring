package com.global.book.repository;

import com.global.book.base.BaseEntity;
import com.global.book.base.BaseRepository;
import com.global.book.entity.Auther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutherRepo extends BaseRepository<Auther, Long>, JpaSpecificationExecutor<Auther> {
    Optional<Auther> findById(Long id) ;



}
