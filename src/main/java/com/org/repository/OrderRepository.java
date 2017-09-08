/**
 * 
 */
package com.org.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Order;

/**
 * @author ahmadrezatabibi
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Serializable>{
	
}
