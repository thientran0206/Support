package com.mytech.mvcshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytech.mvcshop.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
