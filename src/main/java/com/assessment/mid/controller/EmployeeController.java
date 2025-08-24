package com.assessment.mid.controller;

import com.assessment.mid.dto.EmployeeDto;
import com.assessment.mid.entity.Employee;
import com.assessment.mid.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/assessment")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/department/{deptId}")
    public List<EmployeeDto> getEmployeesByDepartment(@PathVariable Long deptId) {

         return employeeService.getEmployees(deptId);
    }

    @PutMapping("/{empId}/department/{deptId}")
    public String changeDepartment(@PathVariable Long empId, @PathVariable Long deptId) {
        return employeeService.changeDepartment(empId, deptId);

    }
}