package com.kh.run;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductSelectRun {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = """
						SELECT
							   PRODUCT_NO
							 , PRODUCT_NAME
							 , SKU
							 , CATEGORY
							 , PRICE
							 , QUANTITY
							 , PRODUCT_DATE
						  FROM
						       TB_PRODUCTS
						 ORDER
						 	BY
						 	   PRODUCT_NO DESC
				     """;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE",
					"SSG13", "SSG131234");
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				int prdNo = rset.getInt("PRODUCT_NO");
				String prdName = rset.getString("PRODUCT_NAME");
				String sku = rset.getString("SKU");
				String category = rset.getString("CATEGORY");
				int price = rset.getInt("PRICE");
				int quantity = rset.getInt("QUANTITY");
				Date prdDate = rset.getDate("PRODUCT_DATE");
				System.out.println("제품ID: "+prdNo +", 제품명: "+prdName + ", 제품식별번호 : "+sku+", 카테고리 : "+category +", 가격 : " + price + ", 재고수량 : " +quantity + ", 생산일 : " +prdDate);
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		

	}

}
