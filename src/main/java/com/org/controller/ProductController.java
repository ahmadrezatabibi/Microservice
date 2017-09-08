/**
 * 
 */
package com.org.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Product;
import com.org.service.ProductService;


/**
 * @author ahmadrezatabibi
 *
 * this Controller will handle Product related requests
 */

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	/**
	 * find Product by id
	 * @param productId
	 * @return Product
	 */
	@RequestMapping("/products/{productId}")
	public Product getProductById(@PathVariable int productId) {
		return this.productService.getProductById(productId);
	}
	
	/**
	 * this method is responsible to show all the products/product catalog
	 * @return List<Product>
	 */
	@RequestMapping("/products")
	public List<Product> getListProducts() {
		return this.productService.getAllProducts();
	}
	
	
}
