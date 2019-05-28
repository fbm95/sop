package com.sop.sopdal.rest;

import com.sop.sopdal.domain.Test;
import com.sop.sopdal.dto.TestDTO;
import com.sop.sopdal.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService service;

    @GetMapping
    public List<Test> getAllTests (){
        return this.service.getAll();
    }

    @PostMapping
    public void addTest(@RequestBody TestDTO dto){
        this.service.transformAndSave(dto);
    }
}
