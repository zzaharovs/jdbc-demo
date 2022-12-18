package ru.zzaharovs.shoppinglist.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.zzaharovs.shoppinglist.service.model.ProductModel;

@Slf4j
@Service
public class OtherService {

    void loggingCustomerRequest(ProductModel model, String customerName) {
        log.info(String.format("Пользователь %s запросил модель %s", customerName, model.toString()));
    }
}
