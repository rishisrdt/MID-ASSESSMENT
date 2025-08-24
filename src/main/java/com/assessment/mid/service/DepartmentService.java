package com.assessment.mid.service;

import com.assessment.mid.dto.DepartmentDto;
import com.assessment.mid.entity.Department;
import com.assessment.mid.entity.Employee;
import com.assessment.mid.mapper.DMapper;
import com.assessment.mid.mapper.EMapper;
import com.assessment.mid.repository.DepartmentRepo;
import com.assessment.mid.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final DMapper dMapper;

    public DepartmentService(DepartmentRepo departmentRepo, DMapper dMapper) {
        this.departmentRepo = departmentRepo;
        this.dMapper = dMapper;
    }


    public DepartmentDto addDepartment(DepartmentDto dto) {
        com.assessment.mid.entity.Department dept = DMapper.toEntity(dto);

        return dMapper.toDto(departmentRepo.save(dept));
    }
}