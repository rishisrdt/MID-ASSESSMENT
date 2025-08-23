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


    public DepartmentDto toDto(Department department){
        DepartmentDto dto = new DepartmentDto();
        dto.setDept_id(department.getDept_id());
        dto.setDept_name( department.getDept_name());
        return dto;

    }

    public List<DepartmentDto> toDto(List<Department>  department){
        return department.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }

//    public Department toEntity(DepartmentDto departmentDto){
//        Department dto = new Department();
//        dto.setDept_id(departmentDto.getDept_id());
//        dto.setDept_name( departmentDto.getDept_name());
//        return dto;
//
//    }

}
