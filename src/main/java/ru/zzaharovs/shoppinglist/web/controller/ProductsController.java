package ru.zzaharovs.shoppinglist.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.zzaharovs.shoppinglist.service.ShoppingListService;
import ru.zzaharovs.shoppinglist.web.dto.CustomerDto;
import ru.zzaharovs.shoppinglist.web.dto.GoodDto;
import ru.zzaharovs.shoppinglist.web.dto.OrderDto;
import ru.zzaharovs.shoppinglist.web.dto.ProductDto;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/shopping-list")
@Validated
@Api(tags = {"Управление списком покупок"})
public class ProductsController {

    private final ShoppingListService shoppingListService;

    @GetMapping("/")
    public List<OrderDto> getProducts(String customerLastName) {
        return shoppingListService.getProducts(customerLastName);
    }

    @GetMapping("/customers")
    @ApiOperation(value = "Получение списка покупателей", produces = "application/json")
    public List<CustomerDto> getCustomers() {
        return shoppingListService.getCustomers();
    }

    @GetMapping("/goods")
    public List<GoodDto> getProducts() {
        return shoppingListService.getProducts();
    }

    @PutMapping("/new")
    public void setProduct(@RequestBody ProductDto model) {
        shoppingListService.setProduct(model);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody ProductDto model) {
        shoppingListService.deleteProduct(model);
    }

}
