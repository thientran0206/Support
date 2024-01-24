package com.mytech.mvcshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mytech.mvcshop.entities.Customer;
import com.mytech.mvcshop.services.CustomerService;
import com.mytech.mvcshop.validators.CustomerValidator;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerValidator customerValidator;

	@GetMapping
	public ModelAndView customerHome() {

		List<Customer> customers = customerService.getCustomers();

		ModelAndView modelAndView = new ModelAndView("customers");
		modelAndView.addObject("customers", customers);

		return modelAndView;
	}

	@GetMapping("/add")
	public String showAddCustomer(Model model) {

		Customer newCustomer = new Customer();
		model.addAttribute("customer", newCustomer);

		return "add_customer";
	}

	@PostMapping("/add")
	public String saveCustomer(@Valid @ModelAttribute Customer customer, BindingResult result) {

		customerValidator.validate(customer, result);
		if (result.hasErrors()) {
			return "add_customer";
		}

		customerService.save(customer);

		return "redirect:/customers";
	}

	@GetMapping("/edit")
	public ModelAndView showEditCustomer(Model model, @RequestParam("id") long id) {

		Customer editCustomer = customerService.getById(id);

		ModelAndView modelAndView = new ModelAndView("edit_customer");
		modelAndView.addObject("customer", editCustomer);

		return modelAndView;
	}

	@PostMapping("/edit")
	public String editCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {

		customerValidator.validate(customer, result);

		if (result.hasErrors()) {
			return "edit_book";
		}

		customerService.update(customer);

		return "redirect:/customers";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") long id) {

		customerService.deleteById(id);
		return "redirect:/customers";
	}
	
	@GetMapping("/search")
	public ModelAndView searchCustomer(@RequestParam("searchText") String searchText) {
		
		List<Customer> customers = customerService.search(searchText);
		
		ModelAndView modelAndView = new ModelAndView("customers");
		modelAndView.addObject("customers", customers);
		
		return modelAndView;
	}
}
