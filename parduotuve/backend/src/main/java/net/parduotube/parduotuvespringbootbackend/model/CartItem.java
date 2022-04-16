package net.parduotube.parduotuvespringbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_cart_item")
public class CartItem {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//	private int quantity;
//	
//	@Temporal(TemporalType.DATE)
//	private Date date;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	private ProductFromDatabase productFromDatabase;
	

		@Id
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
		
		public CartItem() {
			
		}

		public CartItem(String productTitle, String productImageLink, String productDescription, String productContent, int productPrice) {
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


//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public ProductFromDatabase getProductFromDatabase() {
//		return productFromDatabase;
//	}
//
//	public void setProductFromDatabase(ProductFromDatabase productFromDatabase) {
//		this.productFromDatabase = productFromDatabase;
//	}
//
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		CartItem other = (CartItem) obj;
//		return id == other.id;
//	}
//	
	

