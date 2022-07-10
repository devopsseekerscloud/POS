package lk.ijse.pos.POS.controller;

import lk.ijse.pos.POS.dto.request.CustomerRequestDto;
import lk.ijse.pos.POS.service.CustomerService;
import lk.ijse.pos.POS.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
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
    public ResponseEntity<StandardResponse> findCustomer(@RequestParam String id) {
        return new ResponseEntity<>(
                new StandardResponse(200, "Customer Result !",
                        customerService.findCustomer(id)),
                HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponse> updateCustomer(
            @RequestParam String id,
            @RequestBody CustomerRequestDto dto) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer Updated !", customerService.updateCustomer(dto, id)),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping
    public ResponseEntity<StandardResponse> deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(
                new StandardResponse(204, "Customer Deleted !",
                        null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(path = "/list", params = {"searchText", "page", "size"})
    public ResponseEntity<StandardResponse> listAllCustomers(
            @RequestParam(value = "searchText") String searchText,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    ) {
        return new ResponseEntity<>(
                new StandardResponse(200, "Customer List !",
                        customerService.listAllCustomers(
                                searchText, page, size)),
                HttpStatus.OK
        );
    }

}
