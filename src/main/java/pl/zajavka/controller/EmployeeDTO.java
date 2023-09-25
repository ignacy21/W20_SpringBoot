package pl.zajavka.controller;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Integer employeeId;
    private String name;
    private String surname;
    private BigDecimal salary;
    @Size(min = 7, max = 15)
    @Pattern(regexp = "^[+]\\d{2}\\s\\d{3}\\s\\d{3}\\s\\d{3}$")
    private String phone;
    @Email
    private String email;

    public Map<String, String> asMap() {
        Map<String, String> result = new HashMap<>();
        Optional.ofNullable(employeeId).ifPresent(val -> result.put("employeeId", val.toString()));
        Optional.ofNullable(name).ifPresent(val -> result.put("name", val));
        Optional.ofNullable(surname).ifPresent(val -> result.put("surname", val));
        Optional.ofNullable(salary).ifPresent(val -> result.put("salary", val.toString()));
        Optional.ofNullable(phone).ifPresent(val -> result.put("phone", val));
        Optional.ofNullable(email).ifPresent(val -> result.put("email", val));
        return result;
    }
}
