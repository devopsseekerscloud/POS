package lk.ijse.pos.POS.dto.response;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    private String id;
    private String name;
    private String address;
    private double salary;
}
