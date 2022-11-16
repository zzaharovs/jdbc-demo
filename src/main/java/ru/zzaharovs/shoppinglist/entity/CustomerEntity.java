package ru.zzaharovs.shoppinglist.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class CustomerEntity {

    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate registrationDate;

}
