package com.kh.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Products {
	private int product_No;
	private String product_Name;
	private String sku;
	private String category;
	private int price;
	private int quantity;
	private Date product_Date;
	
	
	
	
	public Products() {
		super();
	}
	
	
	
	public Products(int product_No, String product_Name, String sku, String category, int price, int quantity) {
		super();
		this.product_No = product_No;
		this.product_Name = product_Name;
		this.sku = sku;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}


	public Products(int product_No, String product_Name, String sku, String category, int price, int quantity,
			Date product_Date) {
		super();
		this.product_No = product_No;
		this.product_Name = product_Name;
		this.sku = sku;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.product_Date = product_Date;
	}



	public int getProduct_No() {
		return product_No;
	}
	public void setProduct_No(int product_No) {
		this.product_No = product_No;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getProduct_Date() {
		return product_Date;
	}
	public void setProduct_Date(Date product_Date) {
		this.product_Date = product_Date;
	}



	@Override
	public String toString() {
		return "Products [product_No=" + product_No + ", product_Name=" + product_Name + ", sku=" + sku + ", category="
				+ category + ", price=" + price + ", quantity=" + quantity + ", product_Date=" + product_Date + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(category, price, product_Date, product_Name, product_No, quantity, sku);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(category, other.category) && price == other.price
				&& Objects.equals(product_Date, other.product_Date) && Objects.equals(product_Name, other.product_Name)
				&& product_No == other.product_No && quantity == other.quantity && Objects.equals(sku, other.sku);
	}


	
	
}
