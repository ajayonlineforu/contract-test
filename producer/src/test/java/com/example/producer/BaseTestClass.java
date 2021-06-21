package com.example.producer;

import com.example.producer.controller.PersonController;
import com.example.producer.dto.Person;
import com.example.producer.service.PersonService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public abstract class BaseTestClass {

    @Autowired
    private PersonController personRestController;

    @MockBean
    PersonService personService;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(personRestController);

       Mockito.when(personService.findPersonById(1L))
                .thenReturn(new Person(1L, "foo", "bar"));
    }
}
