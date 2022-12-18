package ru.zzaharovs.shoppinglist.dao.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.zzaharovs.shoppinglist.dao.entity.ProductEntity;
import ru.zzaharovs.shoppinglist.service.model.OrderModel;
import ru.zzaharovs.shoppinglist.web.dto.OrderDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShoppingListRepository extends JpaRepository<ProductEntity, UUID> {


    List<ProductEntity> findByProductNameAndCount(String productName, Integer count);

//    List<ProductEntity> findTop500CustomerLastNameOrderByProductIdAsc(String lastName);
//
//    List<ProductEntity> findTop500CustomerLastNameOrderByProductIdAscAndCountDesc(String lastName);

    Integer countAllByProductId(UUID productId);

    Optional<ProductEntity> findByProductIdAndCustomerId(UUID productId, UUID customerId);

//    @Query("select new ru.zzaharovs.shoppinglist.service.model.OrderModel(" +
//            "p.customer.lastName, p.product.name, p.count) from ProductEntity p " +
//            "where p.customer.lastName = :lastname)
//    List<OrderModel> findShortModelByLastName(@Param("lastname") String lastName);

    @Query("select new ru.zzaharovs.shoppinglist.service.model.OrderModel(" +
            "p.customer.lastName, p.product.name, p.count) from ProductEntity p " +
            "where p.customer.lastName = :lastname")
    Page<OrderModel> findShortModelByLastName(@Param("lastname") String lastName, Pageable pageable);

//    @Query(value = "select concat(c.lastname, ' ' , c.firstname) as fullname," +
//            "       g.product_name,\n" +
//            "       concat(g.quantity_in_one, ' ', g.measure) as measure," +
//            "       concat(g.amount, ' ', g.currency) as price_for_one," +
//            "       concat(g.amount * cg.count, ' ', g.currency) as total_sum," +
//            "       cg.count\n" +
//            "  from train.customers " +
//            "  join train.customer_goods cg on c.id = cg.customer_id" +
//            "  join train.goods g on cg.good_id = g.id " +
//            " where upper(c.lastname) = upper(:lastname);\n", nativeQuery = true)
//    List<OrderModel> findShortModelByLastNameRaw(@Param("lastname") String lastName);

    @Query("select p from ProductEntity p " +
            "where p.customer.lastName = :lastname")
    List<ProductEntity> getShoppingListByLastName(@Param("lastname") String lastName);

//    @Query("select p from ProductEntity p " +
//            "where ((select c.lastName from CustomerEntity c where c.id = p.customerId) = :lastname)")
//    List<ProductEntity> getShoppingListByLastNameSecondVariant(@Param("lastname") String lastName);
//
//    @Query("select p from ProductEntity p " +
//            "join CustomerEntity c on p.customerId = c.id " +
//            "where c.lastName = :lastname ")
//    List<ProductEntity> getShoppingListByLastNameThirdVariant(@Param("lastname") String lastName);

    @Query("select p from ProductEntity p " +
            "where p.customer.lastName = :lastname " +
            "and p.customer.age <> ru.zzaharovs.shoppinglist.service.ShoppingListService.CONSTANT_VALUE")
    List<ProductEntity> getShoppingListByLastNameWithAge (@Param("lastname") String lastName);



}
