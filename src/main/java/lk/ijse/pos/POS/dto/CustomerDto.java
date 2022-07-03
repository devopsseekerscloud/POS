package lk.ijse.pos.POS.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String id;
    private String name;
    private String address;
    private double salary;
}
