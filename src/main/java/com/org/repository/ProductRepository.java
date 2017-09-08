/**
 * 
 */
package com.org.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Product;


/**
 * @author ahmadrezatabibi
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Serializable> {

	Product findProductByName(String productName);
}
