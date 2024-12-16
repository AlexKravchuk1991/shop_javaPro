package ait.lesson10.shop_javapro.service;

import ait.lesson10.shop_javapro.model.dto.CustomerDTO;
import ait.lesson10.shop_javapro.model.entity.Cart;
import ait.lesson10.shop_javapro.model.entity.Customer;
import ait.lesson10.shop_javapro.repository.CustomerRepository;
import ait.lesson10.shop_javapro.service.interfaces.CustomerService;
import ait.lesson10.shop_javapro.service.mapping.CustomerMappingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMappingService mappingService;
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMappingService mappingService) {
        this.customerRepository = customerRepository;
        this.mappingService = mappingService;
    }


    @Override
    @Transactional
    public CustomerDTO save(CustomerDTO customerDTO) {
        if(customerDTO!=null){
            Customer customer = mappingService.mapDtoToEntity(customerDTO);
            Cart cart = new Cart();
            cart.setCustomer(customer);
            customer.setCart(cart);


            return mappingService.mapEntityToDto(customerRepository.save(customer));
        }
        return null;
    }

    @Override
    public CustomerDTO findById(Long id) {
        if(customerRepository.findById(id).isPresent()){
            return mappingService.mapEntityToDto(customerRepository.findById(id).get());
        }
        return null;
    }

    @Override
    @Transactional
    public CustomerDTO update(Long id,CustomerDTO customerDTO) {
        if (customerDTO != null) {
            Customer customer = customerRepository.findById(id).get();
            Customer incomingCustomer = mappingService.mapDtoToEntity(customerDTO);
            customer.setName(incomingCustomer.getName());
            customer.setActive(true);
            Customer updatedCustomer = customerRepository.save(customer);
            return mappingService.mapEntityToDto(updatedCustomer);
            }

        return null;
    }

    @Override
    public CustomerDTO delete(Long id) {
        if(id!=null&&id>0&&customerRepository.findById(id).isPresent()){
            Customer customer = customerRepository.findById(id).get();
            customer.setActive(false);
            customerRepository.save(customer);
            return mappingService.mapEntityToDto(customer);
        }
        return null;
    }

    @Override
    public List<CustomerDTO> findAll() {

        return (customerRepository.findAll().stream().filter(Customer::isActive).map(mappingService::mapEntityToDto).toList());
    }
}
