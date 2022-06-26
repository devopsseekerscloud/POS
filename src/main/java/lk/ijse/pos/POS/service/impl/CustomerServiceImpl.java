package lk.ijse.pos.POS.service.impl;

import lk.ijse.pos.POS.dto.request.CustomerRequestDto;
import lk.ijse.pos.POS.entity.Customer;
import lk.ijse.pos.POS.repo.CustomerRepo;
import lk.ijse.pos.POS.service.CustomerService;
import lk.ijse.pos.POS.util.GeneratedIdentificationDto;
import lk.ijse.pos.POS.util.Generator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final Generator generator;

    public CustomerServiceImpl(CustomerRepo customerRepo, Generator generator) {
        this.customerRepo = customerRepo;
        this.generator = generator;
    }


    @Override
    public String saveCustomer(CustomerRequestDto dto) {
        GeneratedIdentificationDto idSet= generator.createId();
        Customer c1= new Customer(
                idSet.getPrefix()+"-C-"+idSet.getId(),dto.getName(),dto.getAddress(),dto.getSalary());
        customerRepo.save(c1);
        return "Customer Saved ! ( "+c1.getId()+" )";
    }

    @Override
    public String findCustomer(String id) {
        return customerRepo.findById(id).toString();
    }

    @Override
    public String updateCustomer(CustomerRequestDto dto, String id) {
        Optional<Customer> customerRecord = customerRepo.findById(id);
        if (customerRecord.isPresent()){
            Customer customer = customerRecord.get();
            customer.setName(dto.getName());
            customer.setAddress(dto.getAddress());
            customer.setSalary(dto.getSalary());
            return "Updated! ( "+(customerRepo.save(customer)).getId()+" )";
        }else{
            return "Empty Result";
        }

    }

    @Override
    public String deleteCustomer(String id) {
        customerRepo.deleteById(id);
        return "Deleted ! ( "+id+" )";
    }

    @Override
    public List<Customer> listAllCustomers() {
        return customerRepo.findAll();
    }
}
