package com.kh.controller;

import java.util.List;

import com.kh.model.dto.ProductsDTO;
import com.kh.model.service.ProductsService;
import com.kh.model.vo.Products;

public class ProductsController {

	public int insertProducts(Products p) {
		int result = new ProductsService().insertProducts(p);
        return result;
	}
	
	public List<Products> printAll() {
        List<Products> products = new ProductsService().printAll();
        return products;
    }
	
	public List<Products> findBySku(String keyword) {
        List<Products> products = new ProductsService().findBySku(keyword);
        return products;
    }

	public int update(String category, String productName, String newName) {
		ProductsDTO product = new ProductsDTO(category, productName, newName);
		
		int result = new ProductsService().update(product);
		return result;
	}

	public int delete(String category, String productName) {
		Products product = new Products();
		product.setCategory(category);
		product.setProduct_Name(productName);
		
		int result = new ProductsService().delete(product);
		
		return result;
	}
	
}
