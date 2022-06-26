package lk.ijse.pos.POS.controller;

import lk.ijse.pos.POS.dto.request.CustomerRequestDto;
import lk.ijse.pos.POS.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public String saveCustomer(@RequestBody CustomerRequestDto dto) {
        return customerService.saveCustomer(dto);
    }

    @GetMapping
    public String findCustomer() {
        return "findCustomer";
    }

    @PutMapping
    public String updateCustomer() {
        return "updateCustomer";
    }

    @DeleteMapping
    public String deleteCustomer() {
        return "deleteCustomer";
    }

    @GetMapping(path = "/list")
    public String listAllCustomers() {
        return "listAllCustomers";
    }

}
