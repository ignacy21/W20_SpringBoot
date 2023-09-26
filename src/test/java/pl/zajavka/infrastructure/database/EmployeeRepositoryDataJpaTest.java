package pl.zajavka.infrastructure.database;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.zajavka.infrastructure.database.entity.EmployeeEntity;
import pl.zajavka.infrastructure.database.repository.EmployeeRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zajavka.util.EntityFixtures.*;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeRepositoryDataJpaTest extends AbstractJpaIt {

    private EmployeeRepository employeeRepository;

    @Test
    void thatEmployeeCanBeSavedCorrectly() {
        // given
        var employees = List.of(someEmployee1(), someEmployee2(), someEmployee3());
        employeeRepository.saveAllAndFlush(employees);

        // when
        List<EmployeeEntity> employeesFound = employeeRepository.findAll();

        // then
        assertThat(employeesFound.size()).isEqualTo(3);
    }
}
