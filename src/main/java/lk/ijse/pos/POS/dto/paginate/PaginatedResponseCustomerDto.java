package lk.ijse.pos.POS.dto.paginate;

import lk.ijse.pos.POS.dto.response.CustomerResponseDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaginatedResponseCustomerDto {
    private List<CustomerResponseDto> list;
    private long dataCount;
}
