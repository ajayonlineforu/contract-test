package com.example.producer.service;

import java.util.HashMap;
import java.util.Map;

import com.example.producer.dto.Person;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PersonService {

    private Map<Long, Person> personMap;

    @PostConstruct
    public void populateMockPersons() {
        personMap = new HashMap<>();
        personMap.put(1L, new Person(1L, "Richard", "Gere"));
        personMap.put(2L, new Person(2L, "Emma", "Choplin"));
        personMap.put(3L, new Person(3L, "Anna", "Carolina"));
    }

    public Person findPersonById(Long id) {
        return personMap.get(id);
    }
}
