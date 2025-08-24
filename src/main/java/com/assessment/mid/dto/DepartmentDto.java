package com.assessment.mid.dto;

import com.assessment.mid.entity.Employee;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public class DepartmentDto {

    private String deptName;
    private List<EmployeeDto> employees;



    public String getDeptName() {
        return deptName;

    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {

        this.employees = employees;
    }
}