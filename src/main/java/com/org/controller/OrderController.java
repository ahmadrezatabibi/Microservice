/**
 * 
 */
package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Order;
import com.org.service.OrderService;

/**
 * @author ahmadrezatabibi
 * 
 * Persisting Order session.setAttribute("orderFromSession", order) 
 * into Session to add new orderItems to it latter on
 * once Customer request for new Item
 *
 */
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	/**
	 * this method is responsible for adding new order items to the order
	 * @param productName
	 * @return Success if the new order item persist to DB/ show error message if the product does not exist
	 */
	@RequestMapping(method=RequestMethod.GET,value="/placeorder/{productName}")
	public String placeOrder(@PathVariable String productName, HttpServletRequest request){
		HttpSession session=request.getSession();
		Order order=(Order)session.getAttribute("orderFromSession");
		if(order==null){
			order=new Order();
			session.setAttribute("orderFromSession", order);
		}try{
			this.orderService.addOrderItem(productName, order);
		}catch(IllegalArgumentException ex){
			return ex.getMessage();
		}
		return "Sucessfully added the order Item";
	}
	
	/**
	 * this method is responsible for displaying the persisted orders with its order items
	 *  @return List<Order>
	 */
	@RequestMapping(method=RequestMethod.GET,value="/orders")
	public List<Order> getAllOrders(){
		return this.orderService.getListAllOrders();
	}
}
