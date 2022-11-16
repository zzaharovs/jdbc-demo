package ru.zzaharovs.shoppinglist.repo;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.zzaharovs.shoppinglist.entity.GoodEntity;

import java.util.List;
import java.util.UUID;

//@Repository
@AllArgsConstructor
public class GoodsRepo {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<GoodEntity> getGood() {
        return namedParameterJdbcTemplate.query(
                "select goods.id from train.goods",
                (rs, rowNum) ->
                        GoodEntity.builder()
                                .id(UUID.fromString(rs.getString("id")))
                                .productName(rs.getString("product_name"))
                                .quantityInOne(rs.getInt("quantity_in_one"))
                                .measure(rs.getString("measure"))
                                .amount(rs.getInt("amount"))
                                .currency((rs.getString("currency")))
                                .build());
    }


}
