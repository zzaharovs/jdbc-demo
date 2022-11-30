package ru.zzaharovs.shoppinglist.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zzaharovs.shoppinglist.dao.repo.CustomerRepository;
import ru.zzaharovs.shoppinglist.dao.repo.GoodsRepository;
import ru.zzaharovs.shoppinglist.dao.repo.ShoppingListRepository;
import ru.zzaharovs.shoppinglist.util.CustomerMapper;
import ru.zzaharovs.shoppinglist.web.dto.CustomerDto;
import ru.zzaharovs.shoppinglist.web.dto.GoodDto;
import ru.zzaharovs.shoppinglist.web.dto.OrderDto;
import ru.zzaharovs.shoppinglist.web.dto.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShoppingListService {

    private final GoodsRepository goodsRepo;
    private final ShoppingListRepository shoppingListRepo;
    private final CustomerRepository customerRepo;
    private final CustomerMapper mapper;

    public List<OrderDto> getProducts(String customerLastName) {
        return shoppingListRepo.getShoppingListByLastname(customerLastName);
    }

    public List<CustomerDto> getCustomers() {
        return customerRepo.getCustomers().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public List<GoodDto> getProducts() {
        return goodsRepo.getGoods().stream()
                .map(x -> GoodDto.builder()
                        .id(x.getId())
                        .productName(x.getProductName())
                        .amount(x.getAmount())
                        .measure(x.getMeasure())
                        .quantityInOne(x.getQuantityInOne())
                        .currency(x.getCurrency())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public void setProduct(ProductDto model) {
        shoppingListRepo.insertRow(model.getProductId(), model.getCustomerId(), model.getCount());
    }

    public void deleteProduct(ProductDto model) {
        shoppingListRepo.deleteRow(model.getProductId(), model.getCustomerId());
    }


}
