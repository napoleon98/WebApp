package com.example.MyWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MyWebApp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
