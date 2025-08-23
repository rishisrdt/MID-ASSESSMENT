package com.assessment.mid.mapper;

import com.assessment.mid.dto.DepartmentDto;
import com.assessment.mid.dto.EmployeeDto;
import com.assessment.mid.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Component
public class EMapper {

    public EmployeeDto toDto(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setEmp_id(employee.getEmp_id());
        dto.setEmp_name( employee.getEmp_name());
        dto.setEmp_email(employee.getEmp_email());
        dto.setDept(employee.getDepartment().getDept_name());
        return dto;

    }

    public List<EmployeeDto> toDtos(List<Employee> employees){
        return employees.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }


}
