package com.kh.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.model.dao.ProductsDao;
import com.kh.model.dto.ProductsDTO;
import com.kh.model.vo.Products;

public class ProductsService {
	private ProductsDao productsdao = new ProductsDao();
	private SqlSession session = null;

	public ProductsService() {
		super();
		this.session = Template.getSqlSession();
	}

	public int insertProducts(Products p) {
		
		int result = productsdao.insertProducts(session, p); 
		
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}

	public List<Products> printAll() {
		
		List<Products> products = productsdao.printAll(session);
		
		session.close();
		
		return products;
	}

	public List<Products> findBySku(String keyword) {
		List<Products> products = productsdao.findBySku(session, keyword);
		
		session.close();
		
		return products;
	}

	public int update(ProductsDTO product) {
		
		int result = productsdao.update(session, product);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
	}

	public int delete(Products product) {
		int result = productsdao.delete(session, product);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
	}
	

}
