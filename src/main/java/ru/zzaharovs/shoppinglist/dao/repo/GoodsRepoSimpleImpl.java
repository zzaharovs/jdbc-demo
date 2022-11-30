package ru.zzaharovs.shoppinglist.dao.repo;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.zzaharovs.shoppinglist.dao.entity.GoodEntity;

import java.util.List;
import java.util.UUID;

//@Repository
@AllArgsConstructor
public class GoodsRepoSimpleImpl implements GoodsRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<GoodEntity> getGoods() {
        return namedParameterJdbcTemplate.query(
                "select * from train.goods",
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
