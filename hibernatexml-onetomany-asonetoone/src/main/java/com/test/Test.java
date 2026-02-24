package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Account;
import com.entities.Locker;
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

			Account account = new Account();
			account.setAccountType("Savings");
			account.setAccountHolderName("Brad");
			account.setIfscCode("IFSC0019");
			account.setBalance(3000);
			
			session.persist(account);

			System.out.println("account no :" + account.getAccountNo());

			Locker locker = new Locker();
			locker.setDimensions("10X10X9");
			locker.setBranchCode("IFSC0019");
			locker.setKeyNo(87);
			locker.setTermsAndConditions("30 days of intimation before closing");
			locker.setCharges(200);
			locker.setAccount(account);

			session.persist(locker);
			
			System.out.println("locker no  : " + locker.getLockerNo());

			Account account2 = session.get(Account.class, 1);
			System.out.println(account2);

			Locker locker2 = session.get(Locker.class, 1);
			System.out.println("key no : " + locker2.getKeyNo());
			
			Account account3 = locker.getAccount();

			System.out.println(account3);

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
