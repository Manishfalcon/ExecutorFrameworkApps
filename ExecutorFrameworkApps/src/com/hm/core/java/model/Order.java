package com.hm.core.java.model;

public class Order {

	public static Order getOrder() {
		System.out.println("Get Order Called");
		return new Order();
	}
	
	public static Order enrichOrder(Order order) {
		System.out.println("Order Enriched");
		return order;
	}
	
	public static Order payment(Order order) {
		System.out.println("Payment Done");
		return order;
	}
	
	public static Order email(Order order) {
		System.out.println("Email Sent");
		System.out.println("---------------");
		return order;
	}
	
}
