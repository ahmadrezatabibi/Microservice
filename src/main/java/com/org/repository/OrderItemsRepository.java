/**
 * 
 */
package com.org.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.OrderItem;

/**
 * @author ahmadrezatabibi
 *
 */
@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Serializable>{

}
