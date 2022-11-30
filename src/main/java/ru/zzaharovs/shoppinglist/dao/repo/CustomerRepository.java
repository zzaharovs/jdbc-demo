package ru.zzaharovs.shoppinglist.dao.repo;

import ru.zzaharovs.shoppinglist.dao.entity.CustomerEntity;

import java.util.List;

public interface CustomerRepository {

    List<CustomerEntity> getCustomers();


}
