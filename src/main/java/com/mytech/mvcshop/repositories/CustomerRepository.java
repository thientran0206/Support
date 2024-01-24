package com.mytech.mvcshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mytech.mvcshop.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "SELECT c FROM Customer c WHERE c.firstName LIKE '%' || :searchText || '%'"
			+ "OR c.lastName LIKE '%' || :searchText || '%'" + "OR c.email LIKE '%' || :searchText || '%'"
			+ "OR c.address.address LIKE '%' || :searchText || '%'")
	public List<Customer> search(@Param("searchText") String searchText);
}
