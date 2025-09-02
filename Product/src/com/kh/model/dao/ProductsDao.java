package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.model.vo.Products;

public class ProductsDao {

	public int insertProducts(Products products) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;

		String sql = "INSERT "
					 + "INTO "
					      + "TB_PRODUCTS "
				   + "VALUES (" + products.getProduct_No()
				   + ", " + "'" + products.getProduct_Name() + "'"
				   + ", " + "'" + products.getSku() + "'"
				   + ", " + "'" + products.getCategory() + "'"
				   + ", " + products.getPrice()
				   + ", " + products.getQuantity() + ", "
				   		  + "SYSDATE"
				          + ")";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "SSG13", "SSG131234");

			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			result = stmt.executeUpdate(sql);

			if (result > 0) {
				conn.commit();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Products> printAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<Products> productslist = new ArrayList();

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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "SSG13", "SSG131234");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				Products p = new Products(rset.getInt("PRODUCT_NO"), rset.getString("PRODUCT_NAME"),
						rset.getString("SKU"), rset.getString("CATEGORY"), rset.getInt("PRICE"),
						rset.getInt("QUANTITY"), rset.getDate("PRODUCT_DATE"));
				productslist.add(p);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return productslist;
	}

	public List<Products> findBySku(String keyword) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<Products> productslist = new ArrayList<>();

		String sql = "SELECT "
						  + "PRODUCT_NO"
						+ ", PRODUCT_NAME"
						+ ", SKU"
						+ ", CATEGORY"
						+ ", PRICE"
						+ ", QUANTITY"
						+ ", PRODUCT_DATE "
					 + "FROM "
						  + "TB_PRODUCTS "
					+ "WHERE "
						  + "SKU LIKE '%" + keyword + "%'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "SSG13", "SSG131234");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				Products p = new Products(rset.getInt("PRODUCT_NO"), rset.getString("PRODUCT_NAME"),
						rset.getString("SKU"), rset.getString("CATEGORY"), rset.getInt("PRICE"),
						rset.getInt("QUANTITY"), rset.getDate("PRODUCT_DATE"));
				productslist.add(p);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return productslist;

	}

}
