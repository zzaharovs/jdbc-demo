package ru.zzaharovs.shoppinglist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OrderShortDto implements OrderDtoResponseble{

    private String lastName;
    private String productName;
    private Integer count;

}
