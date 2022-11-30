package ru.zzaharovs.shoppinglist.util;

import org.mapstruct.Mapper;
import ru.zzaharovs.shoppinglist.dao.entity.CustomerEntity;
import ru.zzaharovs.shoppinglist.web.dto.CustomerDto;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    //    @Mapping(source = "customerEntity.id", target = "id")
    CustomerDto toDto(CustomerEntity customerEntity);

}
