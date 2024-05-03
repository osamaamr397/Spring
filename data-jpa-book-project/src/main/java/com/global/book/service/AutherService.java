package com.global.book.service;

import com.global.book.base.BaseService;
import com.global.book.entity.Auther;
import com.global.book.entity.AutherSearch;
import com.global.book.entity.Book;
import com.global.book.repository.AutherRepo;
import com.global.book.repository.AutherSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutherService extends BaseService<Auther,Long> {
    @Autowired
    private AutherRepo autherRepo;
  @Override
    public Auther update(Auther entity){
        Auther auther=findById(entity.getId());
        auther.setName(entity.getName());
        return super.update(entity);
    }
    public List<Auther>findByAuthSpec(AutherSearch search){
        AutherSpec spec=new AutherSpec(search);
        return autherRepo.findAll(spec);
    }

}
