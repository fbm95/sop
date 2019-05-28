package com.sop.sopdal.service;

import com.sop.sopdal.domain.Test;
import com.sop.sopdal.dto.TestDTO;
import com.sop.sopdal.repository.TestRepository;
import com.sop.sopdal.transformer.TestTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository repository;

    @Autowired
    private TestTransformer transformer;

    public List<Test> getAll(){
        return this.repository.findAll();
    }

    public Test transformAndSave(TestDTO dto){
        return this.save(this.transformer.toEntity(dto));
    }

    public Test save(Test entity){
        return this.repository.save(entity);
    }

}
