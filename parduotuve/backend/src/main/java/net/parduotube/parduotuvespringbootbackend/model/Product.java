package net.parduotube.parduotuvespringbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Product {
	
	
	private String productTitle;
	
	private String productImageLink;
	
	private String productDescription;
	
	private String productContent;
	
	private int productPrice;
	
	private int productCount;
	
	public Product() {
		
	}

	public Product(String productTitle, String productImageLink, String productDescription, String productContent, int productPrice) {
		super();
		this.productTitle = productTitle;
		this.productImageLink = productImageLink;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productContent = productContent;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductImageLink() {
		return productImageLink;
	}

	public void setProductImageLink(String productImageLink) {
		this.productImageLink = productImageLink;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
}
