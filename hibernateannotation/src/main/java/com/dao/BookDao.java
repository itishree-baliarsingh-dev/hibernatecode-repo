package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entities.Book;
import com.helper.SFRegistry;

public class BookDao {
	public Book getBook(int isbn) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Book book = null;

		try {
			sessionFactory = SFRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			book = session.get(Book.class, isbn);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return book;
	}
}
