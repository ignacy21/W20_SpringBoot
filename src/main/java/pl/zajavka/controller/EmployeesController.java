package pl.zajavka.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.zajavka.infrastructure.database.entity.EmployeeEntity;
import pl.zajavka.infrastructure.database.repository.EmployeeRepository;

import java.math.BigDecimal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    @GetMapping
    public String employees(Model model) {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("employeeDTO", new EmployeeDTO());
        return "employees";
    }

    @GetMapping("/show/{employeeId}")
    public String showEmployeeDetails(
            @PathVariable Integer employeeId,
            Model model
    ) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Entity not found, employeeId: [%s]".formatted(employeeId)));

        model.addAttribute("employee", employeeEntity);
        return "employeeDetails";
    }

    @PostMapping("/add")
    @Transactional
    public String addEmployee(
            @Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO
    ) {
        EmployeeEntity newEmployee = EmployeeEntity.builder()
                .name(employeeDTO.getName())
                .surname(employeeDTO.getSurname())
                .salary(employeeDTO.getSalary())
                .phone(employeeDTO.getPhone())
                .email(employeeDTO.getEmail())
                .build();
        employeeRepository.save(newEmployee);
        return "redirect:/employees";
    }

    @PutMapping("/update")
    public String updateEmployee(
            @Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO
    ) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeDTO.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException(
                "Employee not found, employeeId: [%s]".formatted(employeeDTO.getEmployeeId())));

        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setSurname(employeeDTO.getSurname());
        employeeEntity.setSalary(employeeDTO.getSalary());
        employeeEntity.setPhone(employeeDTO.getPhone());
        employeeEntity.setEmail(employeeDTO.getEmail());
        employeeRepository.save(employeeEntity);
        return "redirect:/employees";
    }

    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId) {
        employeeRepository.deleteById(employeeId);
        return "redirect:/employees";
    }
}
