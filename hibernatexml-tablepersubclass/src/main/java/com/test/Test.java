package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.AccidentalInsurancePlan;
import com.entities.InsurancePlan;
import com.entities.MedicalInsurancePlan;
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

			InsurancePlan insurancePlan = new InsurancePlan();
			insurancePlan.setPlanName("Insurance Plan1");
			insurancePlan.setTenure(24);
			insurancePlan.setPremiumAmount(2000);
			insurancePlan.setInsurredAmount(300000);
			insurancePlan.setStatus("A");
			session.persist(insurancePlan);
			System.out.println("Insurance Plan No : " + insurancePlan.getPlanNo());

			MedicalInsurancePlan medicalInsurancePlan = new MedicalInsurancePlan();
			medicalInsurancePlan.setPlanName("Medical Insurance Plan1");
			medicalInsurancePlan.setTenure(120);
			medicalInsurancePlan.setPremiumAmount(12000);
			medicalInsurancePlan.setInsurredAmount(600000);
			medicalInsurancePlan.setStatus("A");
			medicalInsurancePlan.setCopay(10);
			medicalInsurancePlan.setCoverageType("In-Patient");
			session.persist(medicalInsurancePlan);
			System.out.println("medical insurance plan no : " + medicalInsurancePlan.getPlanNo());

			AccidentalInsurancePlan accidentalInsurancePlan = new AccidentalInsurancePlan();
			accidentalInsurancePlan.setPlanName("Accidental Insurance Plan1");
			accidentalInsurancePlan.setTenure(36);
			accidentalInsurancePlan.setPremiumAmount(3000);
			accidentalInsurancePlan.setInsurredAmount(600000);
			accidentalInsurancePlan.setStatus("A");
			accidentalInsurancePlan.setDisabilityCoveragePercentage(60);
			accidentalInsurancePlan.setInternationalCoverage(false);
			session.persist(accidentalInsurancePlan);

			System.out.println("accidental insurance plan no : " + accidentalInsurancePlan.getPlanNo());

			MedicalInsurancePlan medicalInsurancePlan2 = session.get(MedicalInsurancePlan.class, 1);
			System.out.println(medicalInsurancePlan2);

			InsurancePlan insurancePlan2 = session.get(InsurancePlan.class, 1);
			System.out.println(insurancePlan2);

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
