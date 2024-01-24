package com.mytech.mvcshop.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

//	@RequestMapping(path = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String viewHome(Locale locale, Model model) {
		
		Date currentDate = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(currentDate);
		
		model.addAttribute("currentDate", formattedDate);
		
		return "index";
	}
}
