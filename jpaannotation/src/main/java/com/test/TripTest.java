package com.test;

import com.entities.Trip;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TripTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		boolean flag = false;

		try {
			emf = Persistence.createEntityManagerFactory("jpa2");
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();

			Trip trip = em.find(Trip.class, 2);
			System.out.println(trip);
			flag = true;
		} finally {
			if (et != null) {
				if (flag) {
					et.commit();
				} else {
					et.rollback();
				}
			}
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}

	}
}
