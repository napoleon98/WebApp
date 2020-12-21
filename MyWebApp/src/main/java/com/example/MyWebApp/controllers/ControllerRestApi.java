package com.example.MyWebApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyWebApp.model.Department;
import com.example.MyWebApp.model.Department_Location;
import com.example.MyWebApp.model.Employee;
import com.example.MyWebApp.services.DepartmentService;
import com.example.MyWebApp.services.Department_LocationService;
import com.example.MyWebApp.services.EmployeeService;




@RestController
@RequestMapping("/restapi")
public class ControllerRestApi {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private Department_LocationService dept_LocService;
	
	@GetMapping(value= {"locations"},produces = "application/xml")
	public List<Department_Location> listAllDepartmentLocations(){
		
		List<Department_Location> departmentLocations = dept_LocService.listAllDeptLocations();
		
		return departmentLocations;
		
	}
	@GetMapping(value= {"departments"},produces= "application/xml")
	public List<Department> listAlldepartments(){
		
		
		List<Department> departments = departmentService.listAllDepartments();
		return departments;
		
	}
	
	@GetMapping(value="employees/{deptId}",produces="application/xml")
	public List<Employee> listAllEmployeesInSameDept (@PathVariable(name = "deptId")Long deptId){
		List<Employee> employeesInSameDept = employeeService.getEmployeeByDepartmentId(deptId);
		
		return employeesInSameDept;
		
	}
	@GetMapping(value="departments/{locId}",produces= "application/xml")
	public List<Department> listAllDeptsInSameLocation(@PathVariable(name = "locId")Long locId){
		
		List<Department> deptInSameLoc = departmentService.getDeptByLocId(locId);
		return deptInSameLoc;
		
	}
	
	@GetMapping(value="SearchEmployee",produces="application/xml")
	public List<Employee> listAllEmployeesWithSameFullName(@RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName){
		
		List<Employee> employeesWithSameFullName = employeeService.getEmployeeByFullname(firstName, lastName);
		
		return employeesWithSameFullName;
		
	}
	
	@GetMapping(value="employeeById",produces="application/xml")
	public Employee getEmployeeById (@RequestParam("id")Long id) {
		
		return employeeService.getEmployeeById(id);
	}
	

}
