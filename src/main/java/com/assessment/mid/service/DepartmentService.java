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

    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private DMapper dMapper;



    public String addDepartment(Department department) {
        Department dp = departmentRepo.save(department);
        System.out.println(dp);
        Long dep_id = dp.getDept_id();

        List<Employee> emps = department.getEmployees();
        for (Employee ee : emps) {
            Employee newemp = new Employee(
                    ee.getEmp_name(),
                    ee.getEmp_email()
            );
            newemp.setDepartment(dp);
            employeeRepo.save(newemp);
        }
            return "Created";
    }



    public List<DepartmentDto> getDepartments() {
        return dMapper.toDto(departmentRepo.findAll());
    }
}
