package com.assessment.mid.controller;


import com.assessment.mid.dto.DepartmentDto;
import com.assessment.mid.entity.Department;
import com.assessment.mid.entity.Employee;
import com.assessment.mid.service.DepartmentService;
import com.assessment.mid.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assessment")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDto> GetDepartment(){
        return departmentService.getDepartments();
    }

    @PostMapping("/adddepartment")
    public String AddDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }


}
