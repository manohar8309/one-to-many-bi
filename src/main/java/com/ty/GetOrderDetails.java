package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetOrderDetails {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		FoodOrder foodOrder=entityManager.find(FoodOrder.class, 1);
		System.out.println("----order details----");
		System.out.println("id="+foodOrder.getId());
		System.out.println("name="+foodOrder.getName());
		System.out.println("status="+foodOrder.getStatus());
		System.out.println("========================");
		
		List<Itom> itoms=foodOrder.getItoms();
		
		if (itoms!=null) {
			for (Itom itom : itoms) {
				System.out.println("name="+itom.getName());
				System.out.println("quantity="+itom.getQuantity());
				System.out.println("price="+itom.getCost());
				System.out.println("+++++++++++++++++++++++");
			}
			
		}
		
	}

}
