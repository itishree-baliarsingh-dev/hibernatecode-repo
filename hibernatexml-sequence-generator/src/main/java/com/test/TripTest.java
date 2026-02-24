package com.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Trip;
import com.helper.SFRegistry;

public class TripTest {
	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Trip trip = null;

		try {
			sessionFactory = SFRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
//			transaction.begin();

			trip = new Trip();
			trip.setSource("BBSR");
			trip.setDestination("HYD");
			trip.setTripName("dassara holidays");
			trip.setDays(15);
			trip.setStartDate(LocalDate.of(2025, 10, 10));
			trip.setEndDate(LocalDate.of(2025, 10, 25));
			trip.setTripCost(30000);

			session.persist(trip);

			System.out.println("trip no : " + trip.getTripNo());

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
