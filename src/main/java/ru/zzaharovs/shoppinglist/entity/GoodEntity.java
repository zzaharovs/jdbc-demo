package ru.zzaharovs.shoppinglist.entity;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GoodEntity {

    private UUID id;
    private String productName;
    private Integer quantityInOne;
    private String measure;
    private Integer amount;
    private String currency;

}
