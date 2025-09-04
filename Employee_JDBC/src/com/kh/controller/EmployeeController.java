package com.kh.controller;

import java.util.List;

import com.kh.model.dto.EmployeeDTO;
import com.kh.model.service.EmployeeService;
import com.kh.model.vo.Employee;

public class EmployeeController {

	public List<Employee> findAll() {
		
		List<Employee> employees = new EmployeeService().findAll();
		
		return employees;
	}

	public List<Employee> searchdeptCode(String deptcode) {
		
		List<Employee> employees = new EmployeeService().searchdeptCode(deptcode);
		
		return employees;
	}

	public List<Employee> searchjobName(String jobname) {
		List<Employee> employees = new EmployeeService().searchjobName(jobname);
		return employees;
	}

	public Employee searchempId(String empId) {
		Employee employees = new EmployeeService().searchempId(empId);
		return employees;
	}

	public List<Employee> searchTop() {
		List<Employee> employees = new EmployeeService().searchTop();
		
		return employees;
	}

	public List<Employee> searchRow() {
		List<Employee> employees = new EmployeeService().searchRow();
		
		return employees;
	}

	public int save(String empId, String empName, String empNo,String deptCode, String jobCode, String salLevel, int salary) {
		Employee employee = new Employee(empId,empName,empNo,deptCode,jobCode,salLevel, salary);
		
		int result = new EmployeeService().save(employee);
		return 0;
	}

	public int update(String empId, String deptCode, String jobCode, int salary) {
		EmployeeDTO dto = new EmployeeDTO(empId,deptCode,jobCode,salary);
		int result = new EmployeeService().update(dto);
		return result;
	}

	public int delete(String empId) {
		int result = new EmployeeService().delete(empId);
		
		return result;
	}

}
