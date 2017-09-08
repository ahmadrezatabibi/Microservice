/**
 * 
 */
package com.org.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.model.Order;
import com.org.model.OrderItem;
import com.org.model.Product;
import com.org.repository.OrderItemsRepository;
import com.org.repository.OrderRepository;
import com.org.repository.ProductRepository;

/**
 * @author ahmadrezatabibi
 *
 */
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemsRepository orderItemsRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * @param orderId
	 * @return Order
	 */
	public Order getOrderById(int orderId){
		return this.orderRepository.findOne(orderId);
	}
	
	/**
	 * @return List<Order>
	 */
	public List<Order> getListAllOrders(){
		return this.orderRepository.findAll();
	}
	
	/**
	 * @param order
	 */
	public void updateOrderItem(Order order){
		this.orderRepository.save(order);
		
	}
	
	
	/**
	 * this is the helper method which will add products to order
	 * throws IllegalArgumentException if product does not exist
	 * @param productName
	 * @param order
	 */
	public void addOrderItem(String productName, Order order) throws IllegalArgumentException{
		Product product=this.productRepository.findProductByName(productName);
		OrderItem persistedOrderItem=null;
		if(order.getOrderItems()!=null){
			persistedOrderItem=returnPersistedOrderItem(order, productName);
		}else{
			Set<OrderItem> orderItems=new HashSet<>();
			order.setOrderItems(orderItems);
			this.orderRepository.save(order);
		}
		
		if(product!=null){
			if(persistedOrderItem!=null){
				int quantity=persistedOrderItem.getQuantity()+1;
				persistedOrderItem.setQuantity(quantity);
				this.orderItemsRepository.save(persistedOrderItem);
			}else{
				OrderItem newOrderLine=new OrderItem();
				newOrderLine.setQuantity(1);
				newOrderLine.setProduct(product);
				this.orderItemsRepository.save(newOrderLine);
				order.getOrderItems().add(newOrderLine);
			}
			double total=calculateTotalPrice(order);
			order.setTotalPrice(total);
			
			this.orderRepository.save(order);
		}else{
			throw new IllegalArgumentException("product does not exist");
		}
	}
	
	/**
	 * this helper method will return already persisted orderItems
	 * its being used to add to the quantity of orderItem if requested product
	 * already exist in orderItem
	 * @param productName
	 * @param order
	 * @return OrderItem
	 */
	public OrderItem returnPersistedOrderItem(Order order,String productName){
		OrderItem persistedOrderItem=null;
		for(OrderItem orderItem:order.getOrderItems()){
			if(orderItem.getProduct().getName().equalsIgnoreCase(productName)){
				persistedOrderItem=orderItem;
			}
		}
		return persistedOrderItem;
	}
	
	/**
	 * this helper method will return the total price of for all orderItems
	 * @param order
	 * @return double
	 */
	public double calculateTotalPrice(Order order){
		double totalPrice=0;
		for(OrderItem orderItem:order.getOrderItems()){
			totalPrice+=orderItem.getProduct().getPrice()*orderItem.getQuantity();
		}
		return totalPrice;
	}
	

}
