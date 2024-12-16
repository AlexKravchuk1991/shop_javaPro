package ait.lesson10.shop_javapro.controler;

import ait.lesson10.shop_javapro.model.dto.CustomerDTO;
import ait.lesson10.shop_javapro.model.entity.Customer;
import ait.lesson10.shop_javapro.service.interfaces.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer controller",description = "controller for operations with customers ")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDto) {
        return customerService.save(customerDto);
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.findAll();
    }

    @DeleteMapping("/{id}")
    public boolean deleteCustomerById(@PathVariable Long id) {
       if (customerService.findById(id) == null) {
           return false;
       }
       customerService.delete(id);
        return true;
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.update(id, customerDTO);
    }



}
