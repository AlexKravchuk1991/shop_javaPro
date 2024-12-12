package ait.lesson10.shop_javapro.repository;

import ait.lesson10.shop_javapro.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
