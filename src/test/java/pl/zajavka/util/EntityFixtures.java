package pl.zajavka.util;

import lombok.experimental.UtilityClass;
import pl.zajavka.infrastructure.database.entity.EmployeeEntity;

import java.math.BigDecimal;

@UtilityClass
public class EntityFixtures {

    public static EmployeeEntity someEmployee1() {
        return EmployeeEntity.builder()
                .name("Agnieszka")
                .surname("Agnieszkowa")
                .salary(new BigDecimal("123"))
                .phone("+48 123 123 123")
                .email("agnieszkowa@gmail.com")
                .build();
    }
    public static EmployeeEntity someEmployee2() {
        return EmployeeEntity.builder()
                .name("Remigiusz")
                .surname("Remi")
                .salary(new BigDecimal("234"))
                .phone("+48 234 234 234")
                .email("remi@gmail.com")
                .build();
    }
    public static EmployeeEntity someEmployee3() {
        return EmployeeEntity.builder()
                .name("Mariusz")
                .surname("Mariuszowski")
                .salary(new BigDecimal("345"))
                .phone("+48 345 345 345")
                .email("mariuszowski@gmail.com")
                .build();
    }
}
