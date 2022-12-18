package ru.zzaharovs.shoppinglist.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.zzaharovs.shoppinglist.dao.entity.CustomerEntity;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {


    @Query(value = "select count(id) from customers", nativeQuery = true, countQuery = "здесь запрос для пагинации")
    Integer getCountOfCustomers();

    @Query(value = "select * from customers", nativeQuery = true)
    List<CustomerEntity> get111CountOfCustomers();

}
