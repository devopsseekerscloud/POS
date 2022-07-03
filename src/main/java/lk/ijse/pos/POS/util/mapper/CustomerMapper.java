package lk.ijse.pos.POS.util.mapper;

import lk.ijse.pos.POS.dto.CustomerDto;
import lk.ijse.pos.POS.dto.query_interface.CustomerDataInterface;
import lk.ijse.pos.POS.dto.response.CustomerResponseDto;
import lk.ijse.pos.POS.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel="spring")
public interface CustomerMapper {
    Customer toCustomer(CustomerDto dto);
    CustomerDto toCustomerDto(Customer customer);
    List<CustomerResponseDto> toCustomerResponseDto(Page<CustomerDataInterface> list);
}
