package com.kh.model.dto;

import java.util.Objects;

public class ProductsDTO {
	private String category;
	private String product_Name;
	private String newName;
	public ProductsDTO() {
		super();
	}
	
	
	public ProductsDTO(String category, String product_Name, String newName) {
		super();
		this.category = category;
		this.product_Name = product_Name;
		this.newName = newName;
	}


	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	
	@Override
	public String toString() {
		return "ProductsDTO [category=" + category + ", product_Name=" + product_Name + ", newName=" + newName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, newName, product_Name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductsDTO other = (ProductsDTO) obj;
		return Objects.equals(category, other.category) && Objects.equals(newName, other.newName)
				&& Objects.equals(product_Name, other.product_Name);
	}
	
}
