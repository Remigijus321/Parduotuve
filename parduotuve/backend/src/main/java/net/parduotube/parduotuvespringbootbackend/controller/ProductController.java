package net.parduotube.parduotuvespringbootbackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.parduotube.parduotuvespringbootbackend.model.Product;
import net.parduotube.parduotuvespringbootbackend.model.ProductFromDatabase;
import net.parduotube.parduotuvespringbootbackend.model.ProductFromService;
import net.parduotube.parduotuvespringbootbackend.service.ProductService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductService getproductService() {
		return productService;
	}

	public void setproductService(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("products")
	public List<ProductFromDatabase> getproducts() {
		return productService.getProducts();
//				.stream().map(productService -> new Product(productService.getProductTitle(),
//				productService.getProductImageLink(), productService.getProductDescription(),
//				productService.getProductContent(), productService.getProductPrice())).collect(Collectors.toList());
	}
	
	@PostMapping("products")
	public String createproduct(@Valid @RequestBody Product product) {
		return productService.createProduct(new ProductFromService(product.getProductTitle(), product.getProductImageLink(),
				product.getProductDescription(), product.getProductContent(), product.getProductPrice()));
	}
	 
	@GetMapping("products/{id}")
	public ProductFromDatabase findproductById(@PathVariable(name = "id") long id) {
		return productService.findProductById(id);
	}
	
	@PutMapping("products/{id}")
	public String updateproductById(@PathVariable(name = "id") long id, @RequestBody Product productDetails) {
		return productService.updateProductById(id, new ProductFromService(productDetails.getProductTitle(),
				productDetails.getProductImageLink(), productDetails.getProductDescription(), productDetails.getProductContent(), productDetails.getProductPrice()));
	}

	@DeleteMapping("products/{id}")
	public String deleteproductById(@PathVariable(name = "id") long id) {
		return productService.deleteProductById(id);
	}
}
