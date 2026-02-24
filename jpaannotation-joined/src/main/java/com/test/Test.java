package com.test;

import com.entities.AccidentalInsurancePlan;
import com.entities.InsurancePlan;
import com.entities.MedicalInsurancePlan;
import com.helper.EMFRegistry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class Test {
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

			InsurancePlan insurancePlan = new InsurancePlan();
			insurancePlan.setPlanName("Insurance Plan1");
			insurancePlan.setTenure(24);
			insurancePlan.setPremiumAmount(2000);
			insurancePlan.setInsurredAmount(300000);
			insurancePlan.setStatus("A");
			entityManager.persist(insurancePlan);
			System.out.println("Insurance Plan No : " + insurancePlan.getPlanNo());

			MedicalInsurancePlan medicalInsurancePlan = new MedicalInsurancePlan();
			medicalInsurancePlan.setPlanName("Medical Insurance Plan1");
			medicalInsurancePlan.setTenure(120);
			medicalInsurancePlan.setPremiumAmount(12000);
			medicalInsurancePlan.setInsurredAmount(600000);
			medicalInsurancePlan.setStatus("A");
			medicalInsurancePlan.setCopay(10);
			medicalInsurancePlan.setCoverageType("In-Patient");
			entityManager.persist(medicalInsurancePlan);
			System.out.println("medical insurance plan no : " + medicalInsurancePlan.getPlanNo());

			AccidentalInsurancePlan accidentalInsurancePlan = new AccidentalInsurancePlan();
			accidentalInsurancePlan.setPlanName("Accidental Insurance Plan1");
			accidentalInsurancePlan.setTenure(36);
			accidentalInsurancePlan.setPremiumAmount(3000);
			accidentalInsurancePlan.setInsurredAmount(600000);
			accidentalInsurancePlan.setStatus("A");
			accidentalInsurancePlan.setDisabilityCoveragePercentage(60);
			accidentalInsurancePlan.setInternationalCoverage(false);
			entityManager.persist(accidentalInsurancePlan);

			System.out.println("accidental insurance plan no : " + accidentalInsurancePlan.getPlanNo());

			MedicalInsurancePlan medicalInsurancePlan2 = entityManager.find(MedicalInsurancePlan.class, 1);
			System.out.println(medicalInsurancePlan2);

			InsurancePlan insurancePlan2 = entityManager.find(InsurancePlan.class, 1);
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
			if (entityManager != null) {
				entityManager.close();
			}
			EMFRegistry.closeEmf();
		}
	}
}
