package com.test;

import java.time.LocalDate;

import com.entities.Bill;
import com.entities.ItemizedBill;
import com.helper.EMFRegistry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class BillTest {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean flag = false;

		try {
			entityManagerFactory = EMFRegistry.getEmf();
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Bill bill = new Bill();
			bill.setBillGeneratedDate(LocalDate.now());
			bill.setCustomerName("Christian");
			bill.setDueDate(LocalDate.now().plusDays(15));
			bill.setMobileNo("93878484");
			bill.setBillAmount(399);

			entityManager.persist(bill);
			entityManager.flush();
			System.out.println("bill no : " + bill.getBillNo());

			ItemizedBill itemizedBill = new ItemizedBill();
			itemizedBill.setBillNo(bill.getBillNo());
			itemizedBill.setBill(bill);
			
			
			itemizedBill.setInternationalMessages(0);
			itemizedBill.setLocalMessages(100);
			itemizedBill.setLocalVoiceMinutes(1000);
			itemizedBill.setInternationalVoiceMinutes(10);
			itemizedBill.setPreviousDueAmount(300);
			itemizedBill.setBill(bill);

			entityManager.persist(itemizedBill);
			System.out.println("itemized bill no : " + itemizedBill.getBillNo());

//			ItemizedBill itemizedBill2 = entityManager.find(ItemizedBill.class, 1);
//			System.out.println(itemizedBill.getBill());

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
			entityManagerFactory.close();
		}
	}
}
