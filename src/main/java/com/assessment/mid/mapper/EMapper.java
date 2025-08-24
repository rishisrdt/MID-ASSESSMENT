package com.assessment.mid.mapper;

import com.assessment.mid.dto.EmployeeDto;
import com.assessment.mid.entity.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EMapper {

    public static EmployeeDto toDto(Employee e) {
        EmployeeDto dto = new EmployeeDto();
         dto.setEmpName(e.getEmpName());
          dto.setEmpEmail(e.getEmpEmail());
        return dto;
    }

    public static List<EmployeeDto> toDtoList(List<Employee> employees) {
        return employees.stream()
                  .map(EMapper::toDto)
                .collect(Collectors.toList());
    }


    public static Employee toEntity(EmployeeDto dto) {
        Employee e = new Employee();
         e.setEmpName(dto.getEmpName());
         e.setEmpEmail(dto.getEmpEmail());
        return e;
    }
}
