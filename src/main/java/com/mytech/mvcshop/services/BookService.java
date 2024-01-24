package com.mytech.mvcshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.mvcshop.entities.Book;
import com.mytech.mvcshop.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	public List<Book> search(String searchText) {
		return bookRepository.search(searchText);
	}

	public Book save(Book book) {

		return bookRepository.save(book);
	}

	public Book update(Book book) {

		Book updateBook = bookRepository.findById(book.getId()).get();
		
		updateBook.setTitle(book.getTitle());
		updateBook.setAuthor(book.getAuthor());
		updateBook.setPrice(book.getPrice());
		
		return bookRepository.save(updateBook);
	}

	public Book getById(long id) {

		return bookRepository.findById(id).get();
	}

	public void deleteById(long id) {

		bookRepository.deleteById(id);
	}
}
