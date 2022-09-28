package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetHospitalBranchDetails {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Hospital hospital = entityManager.find(Hospital.class, 1);
		System.out.println("-------hospital details-----");
		System.out.println("id =" + hospital.getId());
		System.out.println("name =" + hospital.getName());
		System.out.println("website =" + hospital.getWebsite());
		System.out.println("===========================================");
		List<Branch> branch2 = hospital.getBranchs();
		if (branch2 != null) {
			for (Branch branch : branch2) {
				System.out.println("---branch details------");
				System.out.println("id =" + branch.getId());
				System.out.println("location =" + branch.getLocation());
				System.out.println("city =" + branch.getCity());
				System.out.println("phone =" + branch.getPhone());
				System.out.println("=========================================");
			}

		}

	}

}
