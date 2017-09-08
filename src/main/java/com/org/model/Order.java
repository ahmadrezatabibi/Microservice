/**
 * 
 */
package com.org.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author ahmadrezatabibi
 *
 */
@Entity
@Table(name="Order_AvenuneCode")
public class Order implements Serializable {
	private static final long serialVersionUID = 3952814259757473430L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private double totalPrice;
	
	@OneToMany
	private Set<OrderItem> orderItems;

	
	
	/**
	 * 
	 */
	public Order() {
	}



	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}



	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}



	/**
	 * @return the orderItems
	 */
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}



	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}


	
	
	

}
