package ait.lesson10.shop_javapro.service;

import ait.lesson10.shop_javapro.model.dto.ProductDTO;
import ait.lesson10.shop_javapro.model.entity.Product;
import ait.lesson10.shop_javapro.repository.ProductRepository;
import ait.lesson10.shop_javapro.service.interfaces.ProductService;
import ait.lesson10.shop_javapro.service.mapping.ProductMappingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMappingService mappingService;

    public ProductServiceImpl(ProductRepository productRepository,  ProductMappingService mappingService) {
        this.productRepository = productRepository;
        this.mappingService = mappingService;

    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = mappingService.mapDtoToEntity(productDTO);
        product.setActive(true);
        return mappingService.mapEntityToDto(productRepository.save(product)) ;
    }

    @Override
    public List<ProductDTO> getAllActiveProducts() {

        return productRepository.findAll().stream().filter(Product::isActive).map(mappingService::mapEntityToDto).toList();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null || !product.isActive()) {
            return null;
        }
        return mappingService.mapEntityToDto(product);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO deleteProduct(Long id) {
        return null;
    }

    @Override
    public ProductDTO deleteProductByTitle(String title) {
        return null;
    }

    @Override
    public ProductDTO restoreProductById(Long id) {
        return null;
    }

    @Override
    public long getProductCount() {
        return 0;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return null;
    }

    @Override
    public BigDecimal getAveragePrice() {
        return null;
    }
}
