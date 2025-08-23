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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private EMapper eMapper;



    public Optional<Employee> getEmployee(Long id) {
       return  employeeRepo.findById(id);
    }

    
    public List<EmployeeDto> getEmployees_withDept() {
        List<Employee> allemployee = employeeRepo.findAll();
        List<Employee> allempdep = new ArrayList<>();

        for (Employee emp : allemployee) {
            allempdep.add(emp);
        }

        return eMapper.toDtos(allemployee);
    }


    public String updateEmp(Long id,Long dept_id) {

        Employee em = employeeRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("not found"));
        Department dp = em.getDepartment();
        dp.setDept_id(dept_id);
//        de.setDept_name(employeeDto.getDept());

//        Employee employee = em.setDepartment( de  );
        employeeRepo.save(em);
        return "Updated";
    }
}

