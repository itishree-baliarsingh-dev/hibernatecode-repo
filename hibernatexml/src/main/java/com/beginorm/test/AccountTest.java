package com.beginorm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beginorm.entities.Account;

public class AccountTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();

			Account account = session.get(Account.class, 1001);
			System.out.println(account);
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}

}
