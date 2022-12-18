package ru.zzaharovs.shoppinglist.service;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zzaharovs.shoppinglist.dao.entity.CustomerEntity;
import ru.zzaharovs.shoppinglist.dao.entity.GoodEntity;
import ru.zzaharovs.shoppinglist.dao.entity.ProductEntity;
import ru.zzaharovs.shoppinglist.dao.repo.CustomerRepository;
import ru.zzaharovs.shoppinglist.dao.repo.GoodsRepository;
import ru.zzaharovs.shoppinglist.dao.repo.ShoppingListRepository;
import ru.zzaharovs.shoppinglist.exception.NotFoundException;
import ru.zzaharovs.shoppinglist.service.model.OrderModel;
import ru.zzaharovs.shoppinglist.service.model.ProductModel;
import ru.zzaharovs.shoppinglist.util.CustomerMapper;
import ru.zzaharovs.shoppinglist.web.dto.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShoppingListService {

    public static final int CONSTANT_VALUE = 1;
    private final GoodsRepository goodsRepo;
    private final ShoppingListRepository shoppingListRepo;
    private final CustomerRepository customerRepo;
    private final OtherService service;
    private final CustomerMapper mapper;

    public List<OrderDto> getProducts(String customerLastName) {
        List<ProductEntity> result = shoppingListRepo.getShoppingListByLastName(customerLastName);

        result.forEach(
                x -> service.loggingCustomerRequest(
                        new ProductModel(
                                x.getId(),
                                x.getProduct().getId(),
                                x.getCustomer().getId(),
                                x.getCount()),
                        customerLastName)
        );

        return result
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Page<OrderModel> getProductsShort(String customerLastName, int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return shoppingListRepo.findShortModelByLastName(customerLastName, pageable);
    }

    public Integer getCountOfCustomers() {
        return customerRepo.getCountOfCustomers();
    }

    public List<CustomerDto> getCustomers() {
        return customerRepo.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public List<GoodDto> getProducts() {
        return goodsRepo.findAll().stream()
                .map(x -> GoodDto.builder()
                        .id(x.getId())
                        .productName(x.getName())
                        .amount(x.getAmount())
                        .measure(x.getMeasure())
                        .quantityInOne(x.getQuantityInOne())
                        .currency(x.getCurrency())
                        .build()
                )
                .collect(Collectors.toList());
    }

    @Transactional
    public void setProduct(ProductDto model) {

        GoodEntity good = goodsRepo.findById(model.getProductId())
                .orElseThrow(() -> new NotFoundException(
                        String.format("Good %s not found", model.getProductId())));
        CustomerEntity customer = customerRepo.findById(model.getCustomerId())
                .orElseThrow(() -> new NotFoundException(
                        String.format("Customer %s not found", model.getCustomerId())));

        ProductEntity entity = new ProductEntity();

        entity.setId(UUID.randomUUID());
        entity.setProduct(good);
        entity.setCustomer(customer);
        entity.setCount(model.getCount());
        shoppingListRepo.saveAndFlush(entity);
    }

    public void deleteProduct(ProductDto model) {
        ProductEntity entity = shoppingListRepo.findByProductIdAndCustomerId(
                        model.getProductId(),
                        model.getCustomerId())
                .orElseThrow(() -> new NotFoundException(
                        String.format("Product not found by good id %s and customer id %s",
                                model.getProductId(),
                                model.getCustomerId()
                        )));
        shoppingListRepo.delete(entity);
    }


    private OrderDto toDto(ProductEntity entity) {

        return OrderDto.builder()
                .fullName(String.format("%s %s",
                        entity.getCustomer().getLastName(),
                        entity.getCustomer().getFirstName())
                )
                .productName(entity.getProduct().getName())
                .measure(String.format("%s %s",
                        entity.getProduct().getQuantityInOne(),
                        entity.getProduct().getMeasure())
                )
                .priceForOne(String.format("%s %s",
                        entity.getProduct().getAmount(),
                        entity.getProduct().getCurrency())
                )
                .totalSum(String.format("%d %s",
                        (entity.getProduct().getAmount() * entity.getCount()),
                        entity.getProduct().getCurrency())
                )
                .count(entity.getCount().toString())
                .build();

    }

}
