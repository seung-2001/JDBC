package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.model.dto.ProductsDTO;
import com.kh.model.vo.Products;

public class ProductsDao {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@115.90.212.20:10000:XE";
	private final String USERNAME = "SSG13";
	private final String PASSWORD = "SSG131234";

	public int insertProducts(Connection conn, Products p) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = """
						INSERT
						  INTO
						       TB_PRODUCTS
						VALUES (
							   ?
							 , ?
							 , ?
							 , ?
							 , ?
							 , ?
							 , SYSDATE
							   )
					 """;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getProduct_No() );
			pstmt.setString(2, p.getProduct_Name());
			pstmt.setString(3, p.getSku());
			pstmt.setString(4, p.getCategory());
			pstmt.setInt(5, p.getProduct_No() );
			pstmt.setInt(6, p.getQuantity() );
			conn.setAutoCommit(false);
			result = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<Products> printAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Products> products = new ArrayList();
		
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
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Products product = null;
				products.add(product = new Products(rset.getInt("PRODUCT_NO")
							,rset.getString("PRODUCT_NAME")
							,rset.getString("SKU")
							,rset.getString("CATEGORY")
							,rset.getInt("PRICE")
							,rset.getInt("QUANTITY")
							,rset.getDate("PRODUCT_DATE")
							));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return products;
	}

	public List<Products> findBySku(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Products> products = new ArrayList();
		
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
						 WHERE
						       SKU LIKE '%' || ? || '%'
					 """;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Products product = null;
				products.add(product = new Products(rset.getInt("PRODUCT_NO")
							,rset.getString("PRODUCT_NAME")
							,rset.getString("SKU")
							,rset.getString("CATEGORY")
							,rset.getInt("PRICE")
							,rset.getInt("QUANTITY")
							,rset.getDate("PRODUCT_DATE")
							));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return products;
	}
	
	public int update(Connection conn, ProductsDTO product) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = """
						UPDATE
							   TB_PRODUCTS
						   SET 
				      	       PRODUCT_NAME = ?
				      	 WHERE
							   CATEGORY = ?
				      	   AND
				      	       PRODUCT_NAME = ?
				     """;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getNewName());
			pstmt.setString(2, product.getCategory());
			pstmt.setString(3, product.getProduct_Name());
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int delete(Connection conn, Products product) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = """
						DELETE
					      FROM
					           TB_PRODUCTS
					     WHERE
					           CATEGORY = ?
					       AND
					           PRODUCT_NAME = ?
					 """;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getCategory());
			pstmt.setString(2, product.getProduct_Name());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}
	

}
