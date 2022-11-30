package ru.zzaharovs.shoppinglist.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDto {


    private UUID customerId;
    private UUID productId;
    private Integer count;
}
