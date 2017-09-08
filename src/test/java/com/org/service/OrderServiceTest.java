package com.org.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.Application;
import com.org.model.Order;
import com.org.repository.OrderItemsRepository;
import com.org.service.OrderService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class OrderServiceTest {
	
	@Autowired
	OrderService orderService;
	
	@Autowired 
	OrderItemsRepository orderItemRepository;
	
	
	@Test
	public void addOrderItem_WhenSuccess(){
		Order newOrder=new Order();
		this.orderService.addOrderItem("iPhone", newOrder);
		String persistedProductName=orderItemRepository.findAll().get(0).getProduct().getName();
		assertEquals(persistedProductName, "iPhone");
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void addOrderItem_WhenFails(){
		Order newOrder=new Order();
		this.orderService.addOrderItem("NonExistingProduct", newOrder);
	}
}
