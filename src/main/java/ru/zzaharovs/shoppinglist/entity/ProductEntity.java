package ru.zzaharovs.shoppinglist.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductEntity {

    private UUID customerId;
    private UUID productId;
    private Integer count;
}
