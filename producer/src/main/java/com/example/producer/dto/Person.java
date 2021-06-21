package com.example.producer.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private Long id;
    private String name;
    private String surname;
}
