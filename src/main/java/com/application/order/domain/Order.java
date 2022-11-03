package com.application.order.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity(name = "Order")
@Table(name = "ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long orderNumber;
	@NotEmpty
	@Pattern(regexp = "^[0-9]*$", message = "invalid phone number")
	String phone;
	String item;
	@Column(name = "quantity")
	int qty;
	@Column(precision = 2)
	float price;
	@Column(precision = 2)
	float total;
	@Column(name = "Order_Date")
	@DateTimeFormat(pattern = "mm/dd/yy")
	Date orderDt;
}
