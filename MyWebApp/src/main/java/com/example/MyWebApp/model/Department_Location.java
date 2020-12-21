package com.example.MyWebApp.model;


import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;



@Entity
@Table(name="Dept_Locations")
public class Department_Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Locid;
	
	@Column(name="Locname")
	private String Locname;

	
	
	public Long getLocid() {
		return Locid;
	}

	public void setLocid(Long locid) {
		Locid = locid;
	}

	public String getLocname() {
		return Locname;
	}

	public void setLocname(String locname) {
		Locname = locname;
	}
	
	
	
	
	
	
	
	
}
