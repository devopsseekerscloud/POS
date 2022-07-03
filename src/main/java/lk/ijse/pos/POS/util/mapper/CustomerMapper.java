package lk.ijse.pos.POS.util.mapper;

import lk.ijse.pos.POS.dto.CustomerDto;
import lk.ijse.pos.POS.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CustomerMapper {
    Customer toCustomer(CustomerDto dto);
    CustomerDto toCustomerDto(Customer customer);
}
