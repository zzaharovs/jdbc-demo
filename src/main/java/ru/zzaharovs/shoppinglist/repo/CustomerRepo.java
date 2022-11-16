package ru.zzaharovs.shoppinglist.repo;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.zzaharovs.shoppinglist.entity.CustomerEntity;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class CustomerRepo {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public List<CustomerEntity> getCustomers() {
        return namedParameterJdbcTemplate.query(
                "select * from train.customers",
                (rs, rowNum) ->
                        CustomerEntity.builder()
                                .id(UUID.fromString(rs.getString("id")))
                                .firstName(rs.getString("firstname"))
                                .lastName(rs.getString("lastname"))
                                .age(rs.getInt("age"))
                                .build());

    }

}
