package com.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.SetTopBox;
import com.entities.Subscription;
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

			SetTopBox setTopbox = SetTopBox.of().boxType("HD").manufacturer("Cisco").price(500).build();
			session.persist(setTopbox);
			System.out.println("settop box no : " + setTopbox.getSerialNo());

			
			SetTopBox setTopbox2 = session.get(SetTopBox.class, 1);

			Subscription subscription = Subscription.of().subscriberName("Andy").plan("Ultimate999").provider("airtel")
					.monthlyCharges(999).setTopBox(setTopbox).build();
			session.persist(subscription);
			System.out.println("subscription no : " + subscription.getSubscriptionNo());

			
			SetTopBox setTopBox3 = session.get(SetTopBox.class, 1);
			
			Set<Subscription> subscriptions = setTopBox3.getSubscriptions();
			subscriptions.forEach(System.out::println);

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
