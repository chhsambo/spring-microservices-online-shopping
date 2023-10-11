package com.sambochhay.simpleonlineshopping.orderservice.repositories;

import com.sambochhay.simpleonlineshopping.orderservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
