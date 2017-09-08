/**
 * 
 */
package com.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.model.Product;
import com.org.repository.ProductRepository;


/**
 * @author ahmadrezatabibi
 *
 */

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	/**
	 * @param productId
	 * @return product
	 */
	public Product getProductById(int productId) {	
		return this.productRepository.findOne(productId);
	}
	
	/**
	 * @return List<product>
	 */
	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}
	
	/**
	 * @param product
	 */
	public void addProduct(Product product){
		this.productRepository.save(product);
	}

}
