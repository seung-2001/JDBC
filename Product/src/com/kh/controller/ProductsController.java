package com.kh.controller;

import java.util.List;

import com.kh.model.dao.ProductsDao;
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
	
}
