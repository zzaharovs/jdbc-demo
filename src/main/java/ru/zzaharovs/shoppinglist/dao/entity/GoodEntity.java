package ru.zzaharovs.shoppinglist.dao.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "train", name = "goods")
public class GoodEntity {

    @Id
    private UUID id;
    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;
    @Column(name = "quantity_in_one", nullable = false)
    private Integer quantityInOne;
    @Column(name = "measure", nullable = false)
    private String measure;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "currency", nullable = false)
    private String currency;

}
