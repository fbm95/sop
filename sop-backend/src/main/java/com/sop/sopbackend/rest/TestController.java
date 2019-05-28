package com.sop.sopbackend.rest;

import com.sop.sopbackend.dto.Test;
import com.sop.sopbackend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Test>> getAllTests() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @PostMapping
    public ResponseEntity addTest(@RequestBody Test object) {
        this.service.save(object);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
