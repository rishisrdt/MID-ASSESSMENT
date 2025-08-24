package com.assessment.mid.service;

import com.assessment.mid.dto.EmployeeDto;
import com.assessment.mid.entity.Department;
import com.assessment.mid.entity.Employee;
import com.assessment.mid.mapper.EMapper;
import com.assessment.mid.repository.DepartmentRepo;
import com.assessment.mid.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final DepartmentRepo departmentRepo;

    public EmployeeService(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    public List<EmployeeDto> getEmployees(Long deptId) {
        List<Employee> employees = employeeRepo.findByDepartmentDeptId(deptId);
        return EMapper.toDtoList(employees);
    }



    public String changeDepartment(Long empId, Long newDeptId) {
        Employee emp = employeeRepo.findById(empId).orElseThrow(() ->

                new RuntimeException("Employee not found")
        );

        Department newDept = departmentRepo.findById(newDeptId).
                orElseThrow(() -> new RuntimeException("Department not found")
        );

        emp.setDepartment(newDept);

        employeeRepo.save(emp);
        return "updated successfully.";
    }

}