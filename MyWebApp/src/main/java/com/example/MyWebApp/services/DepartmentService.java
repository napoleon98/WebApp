package com.example.MyWebApp.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyWebApp.model.Department;
import com.example.MyWebApp.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departRepo;
	
	public List<Department> listAllDepartments(){
		
		return departRepo.findAll();
		
	}
	
	public List<Department> getDeptByLocId(Long Locid) {
		
		List <Department> Departments = departRepo.findAll();
		//ArrayList<Department> DepartmentsInSameLocation = new ArrayList<Department>();
		List<Department> DepartmentsInSameLocation = new ArrayList<Department>();
		Long LocidForChecking;
		
		for(int i=0;i<Departments.size();i++) {
			
			LocidForChecking = Departments.get(i).getLocationId();
			//LocidForChecking = Departments.get(index)
			if(LocidForChecking == Locid) {
				
				DepartmentsInSameLocation.add(Departments.get(i));
				
			}
			
		}
		
		return DepartmentsInSameLocation;
	}
		
	
	public Department getdeptById(Long id) {
		Department dept = departRepo.findById(id).get();
		return dept;
	}
	
	
	
	
}
