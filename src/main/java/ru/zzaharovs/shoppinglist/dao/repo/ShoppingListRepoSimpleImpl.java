package ru.zzaharovs.shoppinglist.dao.repo;


import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.zzaharovs.shoppinglist.util.ScriptReader;
import ru.zzaharovs.shoppinglist.web.dto.OrderDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

//@Repository
@AllArgsConstructor
public class ShoppingListRepoSimpleImpl implements ShoppingListRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insertRow(UUID goodId, UUID customerId, int count) {
        String request = ScriptReader.read("insertGood.sql");
        namedParameterJdbcTemplate.update(
                request,
                Map.of("customerId", customerId, "goodId", goodId, "count", count));
    }

    public void deleteRow(UUID goodId, UUID customerId) {
        String request = ScriptReader.read("deleteGood.sql");
        namedParameterJdbcTemplate.update(
                request,
                Map.of("customerId", customerId, "goodId", goodId));
    }

    public List<OrderDto> getShoppingListByLastname(String lastName) {
        String request = ScriptReader.read("findByName.sql");
        return namedParameterJdbcTemplate.query(
                request,
                Map.of("lastname", lastName),
                (rs, rowNum) -> OrderDto.builder()
                        .fullName(rs.getString("fullname"))
                        .productName(rs.getString("product_name"))
                        .measure(rs.getString("measure"))
                        .priceForOne(rs.getString("price_for_one"))
                        .totalSum(rs.getString("total_sum"))
                        .count(rs.getString("count"))
                        .build());
    }



}
