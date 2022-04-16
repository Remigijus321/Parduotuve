package net.parduotube.parduotuvespringbootbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.parduotube.parduotuvespringbootbackend.model.CartItem;

import net.parduotube.parduotuvespringbootbackend.repository.CartItemRepository;
import net.parduotube.parduotuvespringbootbackend.service.CartService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("cart")
	public List<CartItem> getCartItems() {
		return cartService.getCartItems();
	}
	
	@PostMapping("cart")
	public String addItemToCart(@Valid @RequestBody CartItem cartItem) {
		return cartService.addItemToCart(cartItem);
	}
	
	@GetMapping("cart/{id}")
	public CartItem findCartItemById(@PathVariable(name = "id") long id) {
		return cartService.findCartItemById(id);
	}
	
	@DeleteMapping("cart/{id}")
	public String deleteCartItemById(@PathVariable(name = "id") long id) {
		return cartService.deleteCartItemById(id);
	}
}
