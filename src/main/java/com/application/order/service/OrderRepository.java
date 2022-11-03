package com.application.order.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.order.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByPhone(String phone);

}
