package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.dto.EmployeeDTO;
import com.kh.model.vo.Employee;

public class EmployeeDao {
	private Properties prop = new Properties();
	public EmployeeDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/member-mapper.xml"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> findAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Employee> employees = new ArrayList();
		
		String sql = prop.getProperty("findAll");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Employee employee = new Employee(rset.getString("EMP_ID")
												,rset.getString("EMP_NAME")
												,rset.getInt("SALARY")
												,rset.getString("DEPT_TITLE")
												,rset.getString("JOB_NAME"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return employees;
	}

	public List<Employee> searcheptCode(Connection conn, String deptcode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Employee> employees = new ArrayList();
		
		String sql = prop.getProperty("searchdeptCode");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptcode);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Employee employee = new Employee(rset.getString("EMP_ID")
												,rset.getString("EMP_NAME")
												,rset.getInt("SALARY")
												,rset.getString("DEPT_TITLE")
												,rset.getString("JOB_NAME"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return employees;
	}
	public List<Employee> searchjobName(Connection conn, String jobname) {
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchjobName");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jobname);
			rset  = pstmt.executeQuery();
			while(rset.next()) {
				Employee employee = new Employee(rset.getString("EMP_ID")
						,rset.getString("EMP_NAME")
						,rset.getInt("SALARY")
						,rset.getString("DEPT_TITLE")
						,rset.getString("JOB_NAME"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return employees;
	}
	
	public Employee searchempId(Connection conn, String empId) {
		Employee employee = new Employee();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchempId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				employee = new Employee(rset.getString("EMP_ID")
						,rset.getString("EMP_NAME")
						,rset.getInt("SALARY")
						,rset.getString("DEPT_TITLE")
						,rset.getString("JOB_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return employee;
	}
	public List<Employee> searchTop(Connection conn){
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchTop");
		try {
			pstmt = conn.prepareStatement(sql);
			rset  = pstmt.executeQuery();
			while(rset.next()) {
				Employee employee = new Employee(rset.getString("EMP_ID")
						,rset.getString("EMP_NAME")
						,rset.getInt("SALARY")
						,rset.getString("DEPT_TITLE")
						,rset.getString("JOB_NAME"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return employees;
	}
	public List<Employee> searchRow(Connection conn){
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchRow");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Employee employee = new Employee(rset.getString("EMP_ID")
						,rset.getString("EMP_NAME")
						,rset.getInt("SALARY")
						,rset.getString("DEPT_TITLE")
						,rset.getString("JOB_NAME"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return employees;
	}

	public int save(Connection conn, Employee employee) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("save");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getEmpId());
			pstmt.setString(2, employee.getEmpName());
			pstmt.setString(3, employee.getEmpNo());
			pstmt.setString(4, employee.getDeptCode());
			pstmt.setString(5, employee.getJobCode());
			pstmt.setString(6, employee.getSalLevel());
			pstmt.setInt(7, employee.getSalary());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int update(Connection conn, EmployeeDTO dto) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("update");
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSalary());
			pstmt.setString(2, dto.getDeptCode());
			pstmt.setString(3, dto.getJobCode());
			pstmt.setString(4, dto.getEmpId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int delete(Connection conn, String empId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("delete");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
}
