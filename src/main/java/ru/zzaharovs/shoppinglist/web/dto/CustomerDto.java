package ru.zzaharovs.shoppinglist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate registrationDate;

}
