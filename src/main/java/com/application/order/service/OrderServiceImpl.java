package com.application.order.service;

import java.time.Instant;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.order.domain.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;

	@PersistenceContext
	public EntityManager em;

	@Override
	public Float fetchCurrQualifiedTotal(String phone, int months) {
		List<Order> res = orderRepo.findByPhone(phone);
		Float sum = months > 0
				? res.stream()
						.filter(rec -> ChronoUnit.MONTHS.between(
								YearMonth.from(rec.getOrderDt().toInstant().atZone(ZoneId.systemDefault())),
								YearMonth.from(Instant.now().atZone(ZoneId.systemDefault()))) <= months)
						.map(x -> x.getTotal()).reduce((a, b) -> a + b).get()
				: res.stream().map(x -> x.getTotal()).reduce((a, b) -> a + b).get();
		return sum;
	}

	@Override
	public List<Order> fetchOrderTotal(String phone) {
		List<Order> res = orderRepo.findByPhone(phone);
		return res;
	}

}
