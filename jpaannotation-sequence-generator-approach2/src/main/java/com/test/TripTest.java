package com.test;

import java.time.LocalDate;

import com.entities.Trip;
import com.helper.EMFRegistry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class TripTest {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean flag = false;
		Trip  trip = null;

		try {
			entityManagerFactory = EMFRegistry.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			trip = new Trip();
			trip.setSource("DL");
			trip.setDestination("HYD");
			trip.setTripName("pongol holidays");
			trip.setDays(15);
			trip.setStartDate(LocalDate.of(2026, 1, 10));
			trip.setEndDate(LocalDate.of(2026, 1, 25));
			trip.setTripCost(300);

			entityManager.persist(trip);
			
			System.out.println("trip no : "+trip.getTripNo());
			
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
