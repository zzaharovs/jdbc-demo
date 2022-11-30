package ru.zzaharovs.shoppinglist.web.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GoodDto {

    private UUID id;
    private String productName;
    private Integer quantityInOne;
    private String measure;
    private Integer amount;
    private String currency;

}
