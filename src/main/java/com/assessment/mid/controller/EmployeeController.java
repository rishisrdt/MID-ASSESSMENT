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

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Optional<Employee> GetEmpolyee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<EmployeeDto> GetEmpolyees(){
        return employeeService.getEmployees_withDept();
    }

    @PutMapping("/changedepartment/{id}/{dept_id}")
    public String UpdateEmp(@PathVariable Long id,@PathVariable Long dept_id){
        return employeeService.updateEmp(id,dept_id);
    }
}
