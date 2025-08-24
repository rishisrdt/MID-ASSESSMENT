package com.assessment.mid.mapper;

import com.assessment.mid.dto.DepartmentDto;
import com.assessment.mid.dto.EmployeeDto;
import com.assessment.mid.entity.Department;
import com.assessment.mid.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DMapper {

    public static Department toEntity(DepartmentDto dto) {
        Department department = new Department();
        department.setDeptName(dto.getDeptName());

        List<Employee> employees = dto.getEmployees()
                .stream()
                .map(e -> { Employee emp = new Employee();
                       emp.setEmpName(e.getEmpName());
                    emp.setEmpEmail(e.getEmpEmail());
                      emp.setDepartment(department);
                    return emp;
                })
                  .collect(Collectors.toList());

             department.setEmployees(employees);
        return department;
    }

    public static DepartmentDto toDto(Department department) {
        DepartmentDto dto = new DepartmentDto();
            dto.setDeptName(department.getDeptName());

           dto.setEmployees(EMapper.toDtoList(department.getEmployees()));
        return dto;
    }

    public static List<DepartmentDto> toDtoList(List<Department> departments) {
        return departments.stream()
                .map(DMapper::toDto)
                .collect(Collectors.toList());
    }
}
