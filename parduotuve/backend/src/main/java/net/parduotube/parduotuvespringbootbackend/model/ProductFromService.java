package net.parduotube.parduotuvespringbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductFromService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	@Column(name = "product_title")
	private String productTitle;
	
	@Column(name = "product_image_link")
	private String productImageLink;
	
	@Column(name = "product_description")
	private String productDescription;
	
	@Column(name = "product_content")
	private String productContent;
	
	@Column(name = "product_price")
	private int productPrice;
	
	@Column(name = "product_count")
	private int productCount = 1;
	
	public ProductFromService() {
		
	}

	public ProductFromService(String productTitle, String productImageLink, String productDescription, String productContent, int productPrice) {
		super();
		this.productTitle = productTitle;
		this.productImageLink = productImageLink;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productContent = productContent;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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
