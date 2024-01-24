package com.mytech.mvcshop.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.mvcshop.dtos.BookOrderDTO;
import com.mytech.mvcshop.entities.Order;
import com.mytech.mvcshop.entities.OrderItem;
import com.mytech.mvcshop.repositories.BookRepository;
import com.mytech.mvcshop.repositories.CustomerRepository;
import com.mytech.mvcshop.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BookRepository bookRepository;

	public Order placeOrder(BookOrderDTO bookOrderDTO) {
		
		Order newOrder = new Order();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		
		newOrder.setCustomer(customerRepository.findById(bookOrderDTO.getCustomerId()).get());
		
		for (Long bookId : bookOrderDTO.getSelectedBooks()) {
			
			OrderItem newOrderItem = new OrderItem();
			newOrderItem.setBook(bookRepository.findById(bookId).get());
			
			orderItems.add(newOrderItem);
		}
		
		newOrder.setOrderItems(orderItems);
		
		return orderRepository.save(newOrder);
	}
}
