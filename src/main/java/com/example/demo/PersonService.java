package com.example.demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
public class PersonService {
    @PostMapping(value = "/validation")
    public String addPerson(@Valid @RequestBody Person person) {
        return "Person validated";
    }
}