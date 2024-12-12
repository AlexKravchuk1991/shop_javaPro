package ait.lesson10.shop_javapro.service.interfaces;

import ait.lesson10.shop_javapro.model.dto.ProductDTO;
import ait.lesson10.shop_javapro.model.entity.Product;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductDTO saveProduct(ProductDTO productDTO);
    List<ProductDTO> getAllActiveProducts();
    ProductDTO getProductById(Long id);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    ProductDTO deleteProduct(Long id);
    ProductDTO deleteProductByTitle(String title);

    ProductDTO restoreProductById(Long id);
    long getProductCount();
    BigDecimal getTotalPrice();
    BigDecimal getAveragePrice();

}
