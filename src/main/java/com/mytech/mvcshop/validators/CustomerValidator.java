package com.mytech.mvcshop.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mytech.mvcshop.entities.Customer;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.customerFirstName",
				"Customer First Name is required!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.customerLastName",
				"Customer Last Name is required!");
	}
}
