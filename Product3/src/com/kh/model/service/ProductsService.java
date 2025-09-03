package com.kh.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.ProductsDao;
import com.kh.model.dto.ProductsDTO;
import com.kh.model.vo.Products;

public class ProductsService {
	private Connection conn = null;
	
	
	public ProductsService() {
		super();
		this.conn = JDBCTemplate.getConnection();
	}

	public int insertProducts(Products p) {
		
		int result = new ProductsDao().insertProducts(conn, p);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<Products> printAll() {
		
		List<Products> products = new ProductsDao().printAll(conn);
		
		JDBCTemplate.close(conn);
		return products;
	}

	public List<Products> findBySku(String keyword) {
		List<Products> products = new ProductsDao().findBySku(conn,keyword);
		return products;
	}

	public int update(ProductsDTO product) {
		
		int result = new ProductsDao().update(conn, product);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int delete(Products product) {
		int result = new ProductsDao().delete(conn, product);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		JDBCTemplate.close(conn);
		return 0;
	}

}
