package com.example.MyWebApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyWebApp.model.Employee;
import com.example.MyWebApp.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	public List<Employee> listAllEmployees(){
		
		return employeeRepo.findAll();
		
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepo.findById(id).get();
	}
	
	
	public List<Employee> getEmployeeByDepartmentId(Long Deptid) {
		
		List <Employee> Employees = employeeRepo.findAll();
		ArrayList<Employee> EmployeesInSameDepartment = new ArrayList<Employee>();
		Long DeptidForChecking;
		
		for(int i=0;i<Employees.size();i++) {
			
			DeptidForChecking = Employees.get(i).getDepartmentId();
			
			if(DeptidForChecking == Deptid) {
				
				EmployeesInSameDepartment.add(Employees.get(i));
				
			}
			
		}
		
		return EmployeesInSameDepartment;
	}
	

	public List<Employee> getEmployeeByFullname(String firstName, String lastName){
		
		List <Employee> Employees = employeeRepo.findAll();
		ArrayList<Employee> EmployeesWithSameFullname = new ArrayList<Employee>();
		String firstnameForChecking;
		String lastnameForChecking;
		for(int i=0;i<Employees.size();i++) {
			
			firstnameForChecking = Employees.get(i).getFirstname();
			lastnameForChecking = Employees.get(i).getLastname();
			
			if(firstnameForChecking.equals(firstName) && lastnameForChecking.equals(lastName)) {
				
				EmployeesWithSameFullname.add(Employees.get(i));
				
			}
			
		}
		
		return EmployeesWithSameFullname;
		
		
	}


	
}
