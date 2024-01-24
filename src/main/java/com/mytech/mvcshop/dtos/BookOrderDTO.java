package com.mytech.mvcshop.dtos;

public class BookOrderDTO {

	private Long customerId;
	
	private Long[] selectedBooks;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long[] getSelectedBooks() {
		return selectedBooks;
	}

	public void setSelectedBooks(Long[] selectedBooks) {
		this.selectedBooks = selectedBooks;
	}
}
