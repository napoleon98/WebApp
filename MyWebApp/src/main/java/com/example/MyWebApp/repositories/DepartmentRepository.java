package com.example.MyWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MyWebApp.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
