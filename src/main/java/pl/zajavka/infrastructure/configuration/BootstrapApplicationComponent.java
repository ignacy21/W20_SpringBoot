package pl.zajavka.infrastructure.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.infrastructure.database.entity.EmployeeEntity;
import pl.zajavka.infrastructure.database.repository.EmployeeRepository;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class BootstrapApplicationComponent implements ApplicationListener<ContextRefreshedEvent> {

    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        employeeRepository.deleteAll();

        employeeRepository.save(EmployeeEntity.builder()
                .name("Stefan")
                .surname("Stefanowski")
                .salary(new BigDecimal("9324.00"))
                .phone("123 123 123")
                .email("stefan@zajavka.pl")
                .build());
        employeeRepository.save(EmployeeEntity.builder()
                .name("Marcin")
                .surname("Marcinowski")
                .salary(new BigDecimal("7324.00"))
                .phone("234 234 234")
                .email("marcin@zajavka.pl")
                .build());
        employeeRepository.save(EmployeeEntity.builder()
                .name("Agnieszka")
                .surname("Agnieszkowska")
                .salary(new BigDecimal("6324.00"))
                .phone("345 345 345")
                .email("agnieszka@zajavka.pl")
                .build());
    }
}
