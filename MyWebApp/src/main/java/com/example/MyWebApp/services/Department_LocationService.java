package com.example.MyWebApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyWebApp.model.Department_Location;
import com.example.MyWebApp.repositories.Department_LocationRepository;

@Service
public class Department_LocationService {

	@Autowired
	private Department_LocationRepository DeptLocRepo;
	
	public List<Department_Location> listAllDeptLocations(){
		
		return DeptLocRepo.findAll();
		
	}
	
	public Department_Location getLocationOfDeptById(Long locid) {
		
		
		return DeptLocRepo.findById(locid).get();
	}
	
	
 	
	
}
