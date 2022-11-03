package com.application.order.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.application.order.domain.Order;


@Service
public interface OrderService {
	
	List<Order> fetchOrderTotal(String phone);
	
	Float fetchCurrQualifiedTotal(@Valid String phone, @Valid int months);

}
