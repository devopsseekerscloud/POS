package lk.ijse.pos.POS.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CustomerRequestDto {
    private String name;
    private String address;
    private double salary;
}
