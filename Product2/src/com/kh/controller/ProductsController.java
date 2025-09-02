package com.kh.controller;

import java.util.List;

import com.kh.model.dao.ProductsDao;
import com.kh.model.dto.ProductsDTO;
import com.kh.model.vo.Products;

public class ProductsController {

	public int insertProducts(Products p) {
		int result = new ProductsDao().insertProducts(p);
        return result;
	}
	
	public List<Products> printAll() {
        List<Products> products = new ProductsDao().printAll();
        return products;
    }
	
	public List<Products> findBySku(String keyword) {
        List<Products> products = new ProductsDao().findBySku(keyword);
        return products;
    }

	public int update(String category, String productName, String newName) {
		ProductsDTO product = new ProductsDTO(category, productName, newName);
		
		int result = new ProductsDao().update(product);
		return result;
	}

	public int delete(String category, String productName) {
		Products product = new Products();
		product.setCategory(category);
		product.setProduct_Name(productName);
		
		int result = new ProductsDao().delete(product);
		
		return result;
	}
	
}
