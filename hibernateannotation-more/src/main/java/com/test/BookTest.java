package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.BookDao;
import com.entities.Book;
import com.helper.SFRegistry;

public class BookTest {
	public static void main(String[] args) {
		try {
			BookDao dao = new BookDao();
			Book book = dao.getBook(1);
			System.out.println(book);
		} finally {
			SFRegistry.closeSessionFactory();
		}
	}
}
