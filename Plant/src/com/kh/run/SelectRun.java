package com.kh.run;

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
		ResultSet rset = null;
		
		String sql = """
						SELECT 
							   PLT_SPECIES
							 , PLT_NAME
							 , GROW_DAY
						  FROM
							   PLANT
						 ORDER
							BY 
							   GROW_DAY DESC 
				     """;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn =DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE",
					"SSG13", "SSG131234");
			
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				String species = rset.getString("PLT_SPECIES");
				String plantName = rset.getString("PLT_NAME");
				Date growDate = rset.getDate("GROW_DAY");
				System.out.println("번호 : " + species + ", 이름 : " + plantName + ", 등록일 : " + growDate);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
