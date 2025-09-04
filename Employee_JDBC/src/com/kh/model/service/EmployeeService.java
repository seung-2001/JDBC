package com.kh.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.function.Function;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.EmployeeDao;
import com.kh.model.dto.EmployeeDTO;
import com.kh.model.vo.Employee;


public class EmployeeService {
	private Connection conn = null;
	

	public EmployeeService() {
		super();
		this.conn = JDBCTemplate.getConnection();
	}
	
	private <T> T executeQurey(Function<Connection, T> daoFunction) {
		Connection conn = null;
		T result = null;
		conn = getConnection();
		result = daoFunction.apply(conn);
		close(conn);
		return result;
	}

	public List<Employee> findAll() {
		
		return executeQurey(new EmployeeDao()::findAll);
	}

	public List<Employee> searchdeptCode(String deptcode) {
		return executeQurey(conn ->new EmployeeDao().searcheptCode(conn,deptcode));
	}

	public List<Employee> searchjobName(String jobname) {
		return executeQurey(conn ->new EmployeeDao().searchjobName(conn,jobname));
	}

	public Employee searchempId(String empId) {
		return executeQurey(conn ->new EmployeeDao().searchempId(conn,empId));
	}

	public List<Employee> searchTop() {
		return executeQurey(new EmployeeDao()::searchTop);
	}

	public List<Employee> searchRow() {
		return executeQurey(new EmployeeDao()::searchRow);
	}

	public int save(Employee employee) {
		int result = new EmployeeDao().save(conn,employee);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}

	public int update(EmployeeDTO dto) {
		int result = new EmployeeDao().update(conn,dto);
		if(result>0) {
			commit(conn);
		}
		close(conn);
		return result;
	}

	public int delete(String empId) {
		int result = new EmployeeDao().delete(conn,empId);
		if(result>0) {
			commit(conn);
		}
		close(conn);
		return result;
	}

}
