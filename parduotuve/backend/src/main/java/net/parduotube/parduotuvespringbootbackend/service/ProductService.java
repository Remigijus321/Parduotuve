package net.parduotube.parduotuvespringbootbackend.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import net.parduotube.parduotuvespringbootbackend.model.ProductFromDatabase;
import net.parduotube.parduotuvespringbootbackend.model.ProductFromService;
import net.parduotube.parduotuvespringbootbackend.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Transactional
	public List<ProductFromDatabase> getProducts() {
		return productRepository.findAll();
	}
	
	@Transactional
	public String createProduct(@Valid @RequestBody ProductFromService productFromService) {
		 productRepository.save(new ProductFromDatabase(productFromService.getProductTitle(),
				 productFromService.getProductImageLink(),
				 productFromService.getProductDescription(),
				 productFromService.getProductContent(),
				 productFromService.getProductPrice()));
		 
		 return "Phone was successfully created!";
	}
	 
	@Transactional
	public ProductFromDatabase findProductById(@PathVariable(name = "id") long id) {
		ProductFromDatabase productDb = productRepository.findById(id).orElseThrow();
		return productDb;
	}
	
	@Transactional
	public String updateProductById(@PathVariable(name = "id") long id, @RequestBody ProductFromService productDetails) {
		ProductFromDatabase productDb = productRepository.findById(id).orElseThrow();

		productDb.setProductTitle(productDetails.getProductTitle());
		productDb.setProductImageLink(productDetails.getProductImageLink());
		productDb.setProductContent(productDetails.getProductContent());
		productDb.setProductDescription(productDetails.getProductDescription());
		productDb.setProductPrice(productDetails.getProductPrice());

		productRepository.save(productDb);
		return "Phone with id of : " + id + " was successfully updated!";
	}

	@Transactional
	public String deleteProductById(@PathVariable(name = "id") long id) {
		ProductFromDatabase productDb = productRepository.findById(id).orElseThrow();

		productRepository.delete(productDb);
		return "Phone was successfully deleted!";
			
		}

}
