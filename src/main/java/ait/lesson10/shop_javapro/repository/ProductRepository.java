package ait.lesson10.shop_javapro.repository;

import ait.lesson10.shop_javapro.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {


}
