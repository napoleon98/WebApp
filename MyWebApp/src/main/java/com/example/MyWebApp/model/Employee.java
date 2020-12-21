package com.example.MyWebApp.model;

import java.sql.Date;

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
@Table(name="Employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Empid;
	
	@Column(name="Lastname")
	private String Lastname;
	
	@Column(name="Firstname")
	private String Firstname;
	
	@Column(name="Job")
	private String Job;
	
	@Column(name="Hiredate")
	private Date Hiredate;
	
	@Column(name="Salary")
	private float Salary;
	
	@Column(name="Comm")
	private float Comm;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Departnemts_DeptId")
	private Department department;
	
	@ManyToOne
	private Employee manager;

	public Long getEmpid() {
		return Empid;
	}

	public void setEmpid(Long empid) {
		Empid = empid;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}

	public Date getHiredate() {
		return Hiredate;
	}

	public void setHiredate(Date hiredate) {
		Hiredate = hiredate;
	}

	public float getSalary() {
		return Salary;
	}

	public void setSalary(float salary) {
		Salary = salary;
	}

	public float getComm() {
		return Comm;
	}

	public void setComm(float comm) {
		Comm = comm;
	}

	public Long getDepartmentId() {
		return department.getDeptId();
	}

	public void setDepartmentId(Department department) {
		this.department = department;
	}

	public Long getManagerId() {
		return manager.Empid;
	}

	public void setManagerId(Employee manager) {
		this.manager = manager;
	}
	
	
	
	
	
	
	
	
}
