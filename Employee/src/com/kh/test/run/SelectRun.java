package com.kh.test.run;

import java.io.Reader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRun {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset =  null;
		
		String sql = """
				SELECT 
					   EMP_ID
					 , EMP_NAME
					 , EMP_NO
					 , EMAIL
					 , PHONE
					 , DEPT_CODE
					 , JOB_CODE
					 , SAL_LEVEL
					 , SALARY
					 , BONUS
					 , MANAGER_ID
					 , HIRE_DATE
					 , ENT_DATE
					 , ENT_YN
				  FROM
					   EMPLOYEE
				 ORDER
					BY 
					   HIRE_DATE DESC 
		     """;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn =DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE",
					"SSG13", "SSG131234");
			
			System.out.println("DB서버 접속 성공!");
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				int empId = rset.getInt("EMP_ID");
				String empName = rset.getString("EMP_NAME");
				String empNum = rset.getString("EMP_NO");
				String email = rset.getString("EMAIL");
				int phoneNum = rset.getInt("PHONE");
				String deptCode = rset.getString("DEPT_CODE");
				String jobCode = rset.getString("JOB_CODE");
				String salLevel = rset.getString("SAL_LEVEL");
				int salary = rset.getInt("SALARY");
				double bonus = rset.getDouble("BONUS");
				int managerId = rset.getInt("MANAGER_ID");
				Date hireDate = rset.getDate("HIRE_DATE");
				Date entDate = rset.getDate("ENT_DATE");
				String yesNo = rset.getString("ENT_YN");
				System.out.println("사원번호 : " + empId + ", 사원이름 : " + empName + ", 주민번호 : " + empNum
								   + ", 이메일 : " + email
								   + ", 전화번호 : " + phoneNum
								   + ", 부서코드 : " + deptCode
								   + ", 직업코드 : " + jobCode
								   + ", 급여등급 : " + salLevel
								   + ", 급여 : " + salary
								   + ", 보너스 : " + bonus
								   + ", 관리자사번 : "+ managerId
								   + ", 입사일 : " + hireDate
								   + ", 퇴사일 : " + entDate
								   + ", 재직여부 : " + yesNo
								   );
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc 추가했나요?");
			System.out.println("oracle.jdbc.driver.OracleDriver 오타없나요?");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("jdbc:oracle:thin:@115.90.212.20:10000:XE 오타없나요?");
			System.out.println("사용자 계정명 / 비밀번호가 올바르가요?");
			System.out.println("SQL문 잘 썻나요?");
			e.printStackTrace();
		} finally {
			try {
				if(rset != null && !rset.isClosed()) {
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
