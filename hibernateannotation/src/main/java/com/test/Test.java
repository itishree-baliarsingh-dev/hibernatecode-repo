package com.test;

import com.dao.BookDao;
import com.entities.Book;
import com.helper.SFRegistry;

public class Test {
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
