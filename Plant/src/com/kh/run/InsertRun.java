package com.kh.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRun {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;

		Scanner sc = new Scanner(System.in);

		System.out.print("식물의 종을 입력해주세요 > ");
		String species = sc.nextLine();
		System.out.print("식물의 이름을 입력해주세요 > ");
		String name = sc.nextLine();

		String sql = "INSERT INTO PLANT VALUES( " + "'" + species + "', " + "'" + name + "', SYSDATE)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "SSG13", "SSG131234");

			conn.setAutoCommit(false);

			stmt = conn.createStatement();

			result = stmt.executeUpdate(sql);
			System.out.println("SQL문 실행 성공!");

			if (result > 0) { 
				conn.commit();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
