package ait.lesson10.shop_javapro.service;

import ait.lesson10.shop_javapro.model.entity.Customer;
import ait.lesson10.shop_javapro.repository.CustomerRepository;
import ait.lesson10.shop_javapro.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer save(Customer customer) {
        if(customer!=null){
            customer.setActive(true);
            customerRepository.save(customer);
            return customer;
        }
        return null;
    }

    @Override
    public Customer findById(Long id) {
        if(customerRepository.findById(id).isPresent()){
            return customerRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public Customer delete(Long id) {
        if(id!=null&&id>0&&customerRepository.findById(id).isPresent()){
            Customer customer = customerRepository.findById(id).get();
            customer.setActive(false);
            customerRepository.save(customer);
            return customer;
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {

        return customerRepository.findAll().stream().filter(Customer::isActive).toList();
    }
}
