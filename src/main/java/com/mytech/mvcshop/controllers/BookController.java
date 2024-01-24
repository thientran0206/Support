package com.mytech.mvcshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mytech.mvcshop.dtos.BookOrderDTO;
import com.mytech.mvcshop.entities.Book;
import com.mytech.mvcshop.entities.Customer;
import com.mytech.mvcshop.services.BookService;
import com.mytech.mvcshop.services.CustomerService;
import com.mytech.mvcshop.services.OrderService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ModelAndView bookHome() {

		List<Customer> customers = customerService.getCustomers();
		List<Book> books = bookService.getBooks();
		BookOrderDTO bookOrderDTO = new BookOrderDTO();

		ModelAndView modelAndView = new ModelAndView("books");
		modelAndView.addObject("customers", customers);
		modelAndView.addObject("books", books);
		modelAndView.addObject("bookOrder", bookOrderDTO);
		
		return modelAndView;
	}
	
	@PostMapping("/checkout")
	public String checkOut(@ModelAttribute("bookOrder") BookOrderDTO bookOrderDTO) {
		
		orderService.placeOrder(bookOrderDTO);
		
		return "redirect:/books";
	}
}
