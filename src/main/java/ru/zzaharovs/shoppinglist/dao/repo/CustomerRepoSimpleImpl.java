package ru.zzaharovs.shoppinglist.dao.repo;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.zzaharovs.shoppinglist.dao.entity.CustomerEntity;

import java.util.List;
import java.util.UUID;

//@Repository
@AllArgsConstructor
public class CustomerRepoSimpleImpl implements CustomerRepository {

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
