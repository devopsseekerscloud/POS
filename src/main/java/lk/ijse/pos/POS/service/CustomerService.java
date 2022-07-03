package lk.ijse.pos.POS.service;

import lk.ijse.pos.POS.dto.request.CustomerRequestDto;
import lk.ijse.pos.POS.dto.response.CustomerResponseDto;
import lk.ijse.pos.POS.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerRequestDto dto);

    public CustomerResponseDto findCustomer(String id);

    public void updateCustomer(CustomerRequestDto dto, String Id) throws ClassNotFoundException;

    public void deleteCustomer(String id);

    public List<CustomerResponseDto> listAllCustomers();
}
