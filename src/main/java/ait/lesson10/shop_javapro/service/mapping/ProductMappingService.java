package ait.lesson10.shop_javapro.service.mapping;

import ait.lesson10.shop_javapro.model.dto.ProductDTO;
import ait.lesson10.shop_javapro.model.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Service;


@Mapper(componentModel = "spring")
public interface ProductMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active",constant = "true")
    public  Product mapDtoToEntity(ProductDTO dto) ;

    public  ProductDTO mapEntityToDto(Product product);

//    public Product mapDtoToEntity(ProductDTO dto) {
//        Product entity = new Product();
//        entity.setTitle(dto.getTitle());
//        entity.setPrice(dto.getPrice());
//        return entity;
//    }
//
//    public ProductDTO mapEntityToDto(Product product) {
//        ProductDTO dto = new ProductDTO();
//        dto.setId(product.getId());
//        dto.setTitle(product.getTitle());
//        dto.setPrice(product.getPrice());
//        return dto;
//    }


}
