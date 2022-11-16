package ru.zzaharovs.shoppinglist.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zzaharovs.shoppinglist.entity.CustomerEntity;
import ru.zzaharovs.shoppinglist.entity.GoodEntity;
import ru.zzaharovs.shoppinglist.entity.ProductEntity;
import ru.zzaharovs.shoppinglist.model.OrderModel;
import ru.zzaharovs.shoppinglist.repo.CustomerRepo;
import ru.zzaharovs.shoppinglist.repo.GoodsRepo;
import ru.zzaharovs.shoppinglist.repo.ShoppingListRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingListService {

    private final GoodsRepo goodsRepo;
    private final ShoppingListRepo shoppingListRepo;
    private final CustomerRepo customerRepo;

    public List<OrderModel> getProducts(String customerLastName) {
        return shoppingListRepo.getShoppingListByLastname(customerLastName);
    }
    public List<CustomerEntity> getCustomers() {
        return customerRepo.getCustomers();
    }

    public List<GoodEntity> getProducts() {
        return goodsRepo.getGood();
    }

    public void setProduct(ProductEntity model) {
        shoppingListRepo.insertRow(model.getProductId(), model.getCustomerId(), model.getCount());
    }

    public void deleteProduct(ProductEntity model) {
        shoppingListRepo.deleteRow(model.getProductId(), model.getCustomerId());
    }


}
