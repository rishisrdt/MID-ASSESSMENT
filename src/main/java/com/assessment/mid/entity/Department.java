package com.assessment.mid.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;

    @Column(unique = true)
    private String deptName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Long getDeptId(){
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId; }

    public String getDeptName() {
        return deptName; }

    public void setDeptName(String deptName) {
        this.deptName = deptName; }

    public List<Employee> getEmployees(){

        return employees; }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees; }
}