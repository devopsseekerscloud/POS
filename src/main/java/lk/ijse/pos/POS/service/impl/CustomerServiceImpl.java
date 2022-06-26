package lk.ijse.pos.POS.service.impl;

import lk.ijse.pos.POS.dto.request.CustomerRequestDto;
import lk.ijse.pos.POS.entity.Customer;
import lk.ijse.pos.POS.repo.CustomerRepo;
import lk.ijse.pos.POS.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    @Override
    public String saveCustomer(CustomerRequestDto dto) {
        Customer c1= new Customer("C-1",dto.getName(),dto.getAddress(),dto.getSalary());
        customerRepo.save(c1);
        return "Customer Saved ! ( "+c1.getId()+" )";
    }

    @Override
    public String findCustomer(String id) {
        return null;
    }

    @Override
    public String updateCustomer(CustomerRequestDto dto, String Id) {
        return null;
    }

    @Override
    public String deleteCustomer(String id) {
        return null;
    }

    @Override
    public String listAllCustomers() {
        return null;
    }
}
