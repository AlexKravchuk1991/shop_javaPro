package ait.lesson10.shop_javapro.service.mapping;

import ait.lesson10.shop_javapro.model.dto.CustomerDTO;
import ait.lesson10.shop_javapro.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    public Customer mapDtoToEntity(CustomerDTO dto);


    public CustomerDTO mapEntityToDto(Customer entity);
}
