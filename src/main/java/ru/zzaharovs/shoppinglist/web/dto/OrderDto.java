package ru.zzaharovs.shoppinglist.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto{

    @ApiModelProperty("Полное имя пользователя")
    private String fullName;
    private String productName;
    private String measure;
    private String priceForOne;
    private String totalSum;
    private String count;

}
