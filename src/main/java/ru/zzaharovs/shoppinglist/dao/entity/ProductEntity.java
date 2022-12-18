package ru.zzaharovs.shoppinglist.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "train", name = "customer_goods")
public class ProductEntity {

    @Id
    private UUID id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

//    @Column(name = "customer_id")
//    private UUID customerId;

    @OneToOne(optional = false)
    @JoinColumn(name = "good_id", nullable = false)
    private GoodEntity product;

    @Column(name = "count")
    private Integer count;
}
