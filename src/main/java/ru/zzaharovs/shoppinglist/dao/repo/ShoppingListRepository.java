package ru.zzaharovs.shoppinglist.dao.repo;

import ru.zzaharovs.shoppinglist.web.dto.OrderDto;

import java.util.List;
import java.util.UUID;

public interface ShoppingListRepository {


    void insertRow(UUID goodId, UUID customerId, int count);

    void deleteRow(UUID goodId, UUID customerId);

    List<OrderDto> getShoppingListByLastname(String lastName);

}
