package com.example.producer.controller;

import com.example.producer.dto.Person;


import com.example.producer.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping("/person/{id}")
    public Person findPersonById(@PathVariable("id") Long id) {
        Person person = personService.findPersonById(id);
        return person;
    }
}
