package ru.zzaharovs.shoppinglist.controller;


import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.zzaharovs.shoppinglist.entity.CustomerEntity;
import ru.zzaharovs.shoppinglist.entity.GoodEntity;
import ru.zzaharovs.shoppinglist.model.OrderModel;
import ru.zzaharovs.shoppinglist.entity.ProductEntity;
import ru.zzaharovs.shoppinglist.service.ShoppingListService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/shopping-list")
@Validated
public class ProductsController {

    private final ShoppingListService shoppingListService;

    @GetMapping("/")
    public List<OrderModel> getProducts(String customerLastName) {
        return shoppingListService.getProducts(customerLastName);
    }

    @GetMapping("/customers")
    public List<CustomerEntity> getCustomers() {
        return shoppingListService.getCustomers();
    }

    @GetMapping("/goods")
    public List<GoodEntity> getProducts() {
        return shoppingListService.getProducts();
    }

    @PutMapping("/new")
    public void setProduct(@RequestBody ProductEntity model) {
        shoppingListService.setProduct(model);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody ProductEntity model) {
        shoppingListService.deleteProduct(model);
    }

}
