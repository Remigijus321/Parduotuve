package net.parduotube.parduotuvespringbootbackend.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import net.parduotube.parduotuvespringbootbackend.model.CartItem;
import net.parduotube.parduotuvespringbootbackend.repository.CartItemRepository;

@Service
public class CartService {
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	public CartItemRepository getCartItemRepository() {
		return cartItemRepository;
	}
	
	public void setCartItemRepository(CartItemRepository cartItemRepository) {
		this.cartItemRepository = cartItemRepository;
	}
	
	@Transactional(readOnly = true)
	public List<CartItem> getCartItems() {
		return cartItemRepository.findAll();
	}
	
	@Transactional
	public String addItemToCart(@Valid @RequestBody CartItem cartItem) {
		cartItemRepository.save(cartItem);
		
		return "Item saved successfully!";
	}
	
	@Transactional
	public CartItem findCartItemById(@PathVariable(name = "id") long id) {
		return cartItemRepository.findById(id).orElseThrow();
	}

	@Transactional
	public String deleteCartItemById(@PathVariable(name = "id") long id) {
		cartItemRepository.deleteById(id);
		
		return "Item deleted successfully!";
		
	}

}

