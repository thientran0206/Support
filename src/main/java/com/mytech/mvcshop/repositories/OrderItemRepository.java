package com.mytech.mvcshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytech.mvcshop.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
