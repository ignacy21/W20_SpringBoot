package pl.zajavka.controller;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeDTO {

    private Integer employeeId;
    private String name;
    private String surname;
    private BigDecimal salary;
}
