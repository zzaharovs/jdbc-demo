package ru.zzaharovs.shoppinglist.dao.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.zzaharovs.shoppinglist.dao.entity.ProductEntity;
import ru.zzaharovs.shoppinglist.util.ScriptReader;
import ru.zzaharovs.shoppinglist.web.dto.OrderDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ShoppingListRepoHibernateImpl implements ShoppingListRepository {

    @PersistenceContext
    private final EntityManager em;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    @Transactional
    public void insertRow(UUID goodId, UUID customerId, int count) {

        ProductEntity entity = new ProductEntity();
        entity.setId(UUID.randomUUID());

        entity.setProductId(goodId);
        entity.setCount(count);
        entity.setCustomerId(customerId);

        em.persist(entity);


    }

    @Override
    @Transactional
    public void deleteRow(UUID goodId, UUID customerId) {
        Query query = em.createQuery(
                "delete from ProductEntity p " +
                        "where p.customerId = :customerId " +
                        "and p.productId = :goodId"
        );
        query.setParameter("customerId", customerId);
        query.setParameter("goodId", goodId);
        query.executeUpdate();
    }

    @Override
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
