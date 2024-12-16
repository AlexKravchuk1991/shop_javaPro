package ait.lesson10.shop_javapro.service.interfaces;

import ait.lesson10.shop_javapro.model.dto.CustomerDTO;
import ait.lesson10.shop_javapro.model.entity.Customer;

import java.awt.*;
import java.util.List;

public interface CustomerService {
    CustomerDTO save(CustomerDTO customerDTO);
    CustomerDTO findById(Long id);
    CustomerDTO update(Long id, CustomerDTO customerDTO);
    CustomerDTO delete(Long id);
    List<CustomerDTO> findAll();
}
