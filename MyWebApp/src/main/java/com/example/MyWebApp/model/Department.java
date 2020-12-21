package com.example.MyWebApp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="Departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long DeptId;
	
	@Column(name="Dname")
	private String Dname;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Dept_Locations_Locid")
	private Department_Location location;

	public Long getDeptId() {
		return DeptId;
	}

	public void setDeptId(Long deptId) {
		DeptId = deptId;
	}

	public String getDname() {
		return Dname;
	}

	public void setDname(String dname) {
		Dname = dname;
	}

	public Long getLocationId() {
		return location.getLocid();
	}

	public void setLocationId(Department_Location location) {
		this.location = location;
	}
	
	
	
	

}
