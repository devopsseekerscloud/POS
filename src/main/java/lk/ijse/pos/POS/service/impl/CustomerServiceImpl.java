package lk.ijse.pos.POS.service.impl;

import lk.ijse.pos.POS.dto.request.CustomerRequestDto;
import lk.ijse.pos.POS.dto.response.CustomerResponseDto;
import lk.ijse.pos.POS.entity.Customer;
import lk.ijse.pos.POS.repo.CustomerRepo;
import lk.ijse.pos.POS.service.CustomerService;
import lk.ijse.pos.POS.util.GeneratedIdentificationDto;
import lk.ijse.pos.POS.util.Generator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void saveCustomer(CustomerRequestDto dto) {
        GeneratedIdentificationDto idSet= generator.createId();
        Customer c1= new Customer(
                idSet.getPrefix()+"-C-"+idSet.getId(),dto.getName(),dto.getAddress(),dto.getSalary());
        customerRepo.save(c1);
    }

    @Override
    public CustomerResponseDto findCustomer(String id) {
        Optional<Customer> data = customerRepo.findById(id);
        if(data.isPresent()){
            Customer c= data.get();
            return new CustomerResponseDto(
                    c.getId(),c.getName(),c.getAddress(),c.getSalary()
            );
        }
        return null;
    }

    @Override
    public void updateCustomer(CustomerRequestDto dto, String id) throws ClassNotFoundException {
        Optional<Customer> customerRecord = customerRepo.findById(id);
        if (customerRecord.isPresent()){
            Customer customer = customerRecord.get();
            customer.setName(dto.getName());
            customer.setAddress(dto.getAddress());
            customer.setSalary(dto.getSalary());
        }else{
            throw new ClassNotFoundException();
        }

    }

    @Override
    public void deleteCustomer(String id) {
        customerRepo.deleteById(id);
    }

    @Override
    public List<CustomerResponseDto> listAllCustomers() {
        List<CustomerResponseDto> list= new ArrayList<>();
        for (Customer c:customerRepo.findAll()
             ) {
            list.add(new CustomerResponseDto
                    (c.getId(),c.getName(),c.getAddress(),c.getSalary()));
        }
        return list;
    }
}
