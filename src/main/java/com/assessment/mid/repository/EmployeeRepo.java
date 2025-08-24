package com.assessment.mid.repository;


import com.assessment.mid.dto.EmployeeDto;
import com.assessment.mid.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentDeptId(Long deptId);

}

