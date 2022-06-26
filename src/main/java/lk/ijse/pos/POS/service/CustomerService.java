package lk.ijse.pos.POS.service;

import lk.ijse.pos.POS.dto.request.CustomerRequestDto;
import org.springframework.web.bind.annotation.*;

public interface CustomerService {
    public String saveCustomer(CustomerRequestDto dto);
    public String findCustomer(String id);
    public String updateCustomer(CustomerRequestDto dto, String Id);
    public String deleteCustomer(String id);
    public String listAllCustomers();
}
