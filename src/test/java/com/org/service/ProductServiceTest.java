package com.org.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.Application;
import com.org.model.Product;
import com.org.repository.ProductRepository;
import com.org.service.ProductService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class ProductServiceTest {
	
	@Autowired
	ProductService productService;
	
	@Autowired 
	ProductRepository productRepository;
	
	
	@Test
	public void getAllProducts_WhenSuccess(){
		List<Product> persistedProducts=this.productRepository.findAll();
		assertNotNull(persistedProducts);
	}
	
	@Test
	public void addProducts_WhenSuccess(){
		Product newProduct=new Product("Apple Watch", "Watch", 400.0);
		this.productService.addProduct(newProduct);
		Product persistedProduct=this.productRepository.findProductByName("Apple Watch");
		assertEquals(newProduct.getName(), persistedProduct.getName());
	}
}
