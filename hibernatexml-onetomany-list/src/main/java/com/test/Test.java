package com.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Order;
import com.entities.Restaurant;
import com.helper.SFRegistry;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			sessionFactory = SFRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Order order1 = new Order();
			order1.setCustomerName("Bob");
			order1.setOrderedDate(LocalDate.now());
			order1.setMobileNo("93837484");
			order1.setEmailAddress("bob@live.in");
			order1.setAmount(938);
			session.persist(order1);

			System.out.println("order no  :" + order1.getOrderNo());

			Order order2 = new Order();
			order2.setCustomerName("Joe");
			order2.setOrderedDate(LocalDate.now());
			order2.setMobileNo("92837344");
			order2.setEmailAddress("joe@gmail.com");
			order2.setAmount(1938);
			session.persist(order2);

			System.out.println("order no  :" + order2.getOrderNo());

			Restaurant restaurant = new Restaurant();
			restaurant.setRestaurantName("Kruthunga");
			restaurant.setCuisine("Indian");
			restaurant.setRating(4);
			restaurant.setContactNo("93494844");
			List<Order> orders = new ArrayList<>();
			orders.add(order2);
			orders.add(order1);

			restaurant.setOrders(orders);
			session.persist(restaurant);
			System.out.println("restaurant no : " + restaurant.getRestaurantNo());

			Restaurant restaurant2 = session.get(Restaurant.class, 3);
			System.out.println(restaurant2.getOrders());

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (session != null) {
				session.close();
			}
			SFRegistry.closeSessionFactory();
		}
	}
}
