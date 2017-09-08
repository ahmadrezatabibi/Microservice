/**
 * 
 */
package com.org;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

import com.org.model.Product;
import com.org.service.ProductService;

/**
 * @author ahmadrezatabibi
 *
 */
@SpringBootApplication
@PropertySource(value = "classpath:application.yml")
public class Application extends SpringBootServletInitializer implements CommandLineRunner{

	@Autowired
	private ProductService productService;
	
	/**
	 * Loading the application
	 */
	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "H2DB");
		final SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
	}

	/**
	 * Using CommandLineRunner to put some dummy values to Product Table
	 */
	@Override
	public void run(String... args) throws Exception {
		List<Product> products = Arrays.asList(new Product("iphone", "cellphone", 700.0),
				new Product("galaxys8", "cellphone",800.0), new Product("macbookair", "laptop", 200.34));				
		for (Product product : products) {
			    productService.addProduct(product);
		}
		
	}

}
