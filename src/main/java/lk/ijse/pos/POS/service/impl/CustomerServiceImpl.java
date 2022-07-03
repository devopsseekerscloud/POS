package lk.ijse.pos.POS.service.impl;

import lk.ijse.pos.POS.dto.CustomerDto;
import lk.ijse.pos.POS.dto.request.CustomerRequestDto;
import lk.ijse.pos.POS.dto.response.CustomerResponseDto;
import lk.ijse.pos.POS.entity.Customer;
import lk.ijse.pos.POS.repo.CustomerRepo;
import lk.ijse.pos.POS.service.CustomerService;
import lk.ijse.pos.POS.util.GeneratedIdentificationDto;
import lk.ijse.pos.POS.util.Generator;
import lk.ijse.pos.POS.util.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final Generator generator;

    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, Generator generator, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.generator = generator;
        this.customerMapper = customerMapper;
    }


    @Override
    public String saveCustomer(CustomerRequestDto dto) {
        GeneratedIdentificationDto idSet= generator.createId();
        CustomerDto c1= new CustomerDto(
                idSet.getPrefix()+"-C-"+idSet.getId(),dto.getName(),dto.getAddress(),dto.getSalary());

        return customerRepo.save(customerMapper.toCustomer(c1)).getId();
    }

    @Override
    public CustomerResponseDto findCustomer(String id) {
        Optional<Customer> data = customerRepo.findById(id);
        if(data.isPresent()){
            CustomerDto dto = customerMapper.toCustomerDto(data.get());
            return new CustomerResponseDto(
                    dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary()
            );
        }
        return null;
    }

    @Override
    public String updateCustomer(CustomerRequestDto dto, String id) throws ClassNotFoundException {
        Optional<Customer> customerRecord = customerRepo.findById(id);
        if (customerRecord.isPresent()){
            Customer customer = customerRecord.get();
            customer.setName(dto.getName());
            customer.setAddress(dto.getAddress());
            customer.setSalary(dto.getSalary());
            return customerRepo.save(customer).getId();
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
