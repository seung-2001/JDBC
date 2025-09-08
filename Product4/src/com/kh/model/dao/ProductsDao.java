package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.JDBCTemplate;
import com.kh.model.dto.ProductsDTO;
import com.kh.model.vo.Products;

public class ProductsDao {

	public int insertProducts(SqlSession session, Products p) {
		
		return session.insert("insertProducts", p);
	}

	public List<Products> printAll(SqlSession session) {
		
		return session.selectList("printAll");
	}

	public List<Products> findBySku(SqlSession session, String keyword) {
		return session.selectList("findBySku", keyword);
	}

	public int update(SqlSession session, ProductsDTO product) {
		return session.update("update", product);
	}

	public int delete(SqlSession session, Products product) {
		return session.delete("delete", product);
	}

		


}
