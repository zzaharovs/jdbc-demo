package ru.zzaharovs.shoppinglist.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class OrderModel {

    private String lastName;
    private String productName;
    private Integer count;

}
