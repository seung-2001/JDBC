package com.kh.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Employee {
	private String empId;
	private String empName;
	private String empNo;
	private String deptCode;
	private String jobCode;
	private String salLevel;
	private int salary;
	private String entYn;
	
	
	
	public Employee() {
		super();
	}

	public Employee(String empId, String empName, int salary, String deptCode, String jobCode) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
	}
	
	public Employee(String empId, String empName, String empNo, String deptCode, String jobCode, String salLevel,int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
	}
	

	public Employee(String empId, String empName, String empNo, String deptCode, String jobCode, String salLevel,
			int salary, String entYn) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.entYn = entYn;
	}

	public String getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public String getJobCode() {
		return jobCode;
	}

	public String getSalLevel() {
		return salLevel;
	}

	public int getSalary() {
		return salary;
	}

	public String getEntYn() {
		return entYn;
	}

	
}
