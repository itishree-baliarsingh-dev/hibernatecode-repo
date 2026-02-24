package com.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Bill;
import com.entities.ItemizedBill;
import com.helper.SFRegistry;

public class BillTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			sessionFactory = SFRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Bill bill = new Bill();
			bill.setBillGeneratedDate(LocalDate.now());
			bill.setCustomerName("Christian");
			bill.setDueDate(LocalDate.now().plusDays(15));
			bill.setMobileNo("93878484");
			bill.setBillAmount(399);

			session.persist(bill);
			System.out.println("bill no : " + bill.getBillNo());

			ItemizedBill itemizedBill = new ItemizedBill();
			itemizedBill.setInternationalMessages(0);
			itemizedBill.setLocalMessages(100);
			itemizedBill.setLocalVoiceMinutes(1000);
			itemizedBill.setInternationalVoiceMinutes(10);
			itemizedBill.setPreviousDueAmount(300);
			itemizedBill.setBill(bill);

			session.persist(itemizedBill);
			System.out.println("itemized bill no : " + itemizedBill.getBillNo());
			
			
			ItemizedBill itemizedBill2 = session.get(ItemizedBill.class, 1);
			System.out.println(itemizedBill2.getBill());

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
