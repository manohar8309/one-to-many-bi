package com.ty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveBranchWithHospital {
	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		hospital.setName("rush");
		hospital.setWebsite("www.rush.com");

		Branch branch = new Branch();
		branch.setLocation(" gandi road");
		branch.setCity("tirupati");
		branch.setPhone(72682736);
		branch.setHospital(hospital);

		Branch branch2 = new Branch();
		branch2.setLocation(" 7 circle");
		branch2.setCity("kadapa");
		branch2.setPhone(635437);
		branch2.setHospital(hospital);

		List<Branch> list = new ArrayList<Branch>();
		list.add(branch);
		list.add(branch2);

		hospital.setBranchs(list);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch);
		entityManager.persist(branch2);
		entityTransaction.commit();

	}

}
