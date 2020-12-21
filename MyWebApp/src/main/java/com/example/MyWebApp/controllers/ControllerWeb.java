package com.example.MyWebApp.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MyWebApp.services.DepartmentService;
import com.example.MyWebApp.services.Department_LocationService;
import com.example.MyWebApp.services.EmployeeService;




@Controller
public class ControllerWeb {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private Department_LocationService dept_LocService;
	
	
	@GetMapping(value = {"/locations", "/locations/Goback"})
	public String locationsPage(Model m) {
		
		m.addAttribute("LocationsList", dept_LocService.listAllDeptLocations());
		
		
		return "locations";
		
	}
	
	@GetMapping("/locations/{locId}")
	public String  deptsInLocationPage(@PathVariable(name = "locId")Long locId, Model m) {
		
		m.addAttribute("alldeptsWithLocId", departmentService.getDeptByLocId(locId));
		
		
		m.addAttribute("locName", dept_LocService.getLocationOfDeptById(locId).getLocname() );
		
		return "departments";
	}
	
	@GetMapping("locations/{locId}/departments/{deptId}")
	public String employessInDepartmentPage(@PathVariable(name = "locId")Long locId,@PathVariable(name = "deptId")Long deptId, Model m) {
	
		m.addAttribute("allEmployeesInDept",employeeService.getEmployeeByDepartmentId(deptId));
		m.addAttribute("locName",dept_LocService.getLocationOfDeptById(locId).getLocname());
		m.addAttribute("DepartmentName",departmentService.getdeptById(deptId).getDname());
		
	
	
	
		return "employees";
	}
	@GetMapping(value = {"locations/{locId}/departments/{deptId}/employees/{empId}"})
	public String employeesDetails(@PathVariable(name = "empId")Long empId,@PathVariable(name = "locId")Long locId,@PathVariable(name = "deptId")Long deptId, Model m) {
		m.addAttribute("FirstName",employeeService.getEmployeeById(empId).getFirstname());
		m.addAttribute("LastName",employeeService.getEmployeeById(empId).getLastname());
		m.addAttribute("comm",employeeService.getEmployeeById(empId).getComm());
		m.addAttribute("hiredate",employeeService.getEmployeeById(empId).getHiredate());
		m.addAttribute("job",employeeService.getEmployeeById(empId).getJob());
		m.addAttribute("salary",employeeService.getEmployeeById(empId).getSalary());
		m.addAttribute("DeptId",employeeService.getEmployeeById(empId).getDepartmentId());
		m.addAttribute("managerID",employeeService.getEmployeeById(empId).getManagerId());
		m.addAttribute("empId",empId);
		m.addAttribute("locId",locId);
		
		return "employeeDetails";
	}
	
}
