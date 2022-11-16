package ru.zzaharovs.shoppinglist.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderModel {

    private String fullName;
    private String productName;
    private String measure;
    private String priceForOne;
    private String totalSum;
    private String count;


}
