package com.test;

import java.time.LocalDate;

import com.entities.Order;
import com.helper.EMFRegistry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class OrderTest {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean flag = false;
		Order order = null;

		try {
			entityManagerFactory = EMFRegistry.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			order = new Order();
			order.setCustomerName("iti");
			order.setOrderedDate(LocalDate.now());
			order.setAmount(20000);

			entityManager.persist(order);
			System.out.println(order);

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (entityManager != null) {
				entityManager.close();
			}
			EMFRegistry.closeEntityManagerFactory();
		}
	}
}
