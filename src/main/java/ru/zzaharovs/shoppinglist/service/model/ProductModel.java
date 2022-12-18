package ru.zzaharovs.shoppinglist.service.model;

import lombok.*;
import ru.zzaharovs.shoppinglist.dao.entity.CustomerEntity;
import ru.zzaharovs.shoppinglist.dao.entity.GoodEntity;

import javax.persistence.*;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductModel {

    private UUID id;

    private UUID customerId;

    private UUID productId;

    private Integer count;

}