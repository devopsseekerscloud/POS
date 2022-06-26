package lk.ijse.pos.POS.controller;

import lk.ijse.pos.POS.dto.request.CustomerRequestDto;
import lk.ijse.pos.POS.service.CustomerService;
import lk.ijse.pos.POS.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerRequestDto dto) {
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer Saved !",
                        customerService.saveCustomer(dto)),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public String findCustomer(@RequestParam String id) {
        return customerService.findCustomer(id);
    }

    @PutMapping
    public String updateCustomer(
            @RequestParam String id,
            @RequestBody CustomerRequestDto dto) {
        return customerService.updateCustomer(dto, id);
    }

    @DeleteMapping
    public String deleteCustomer(@RequestParam String id) {
        return customerService.deleteCustomer(id);
    }

    @GetMapping(path = "/list")
    public List listAllCustomers() {
        return customerService.listAllCustomers();
    }

}
