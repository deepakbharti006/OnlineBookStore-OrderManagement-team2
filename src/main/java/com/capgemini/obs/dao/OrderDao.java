package com.capgemini.obs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capgemini.obs.entity.OrderInfo;

@Repository
public class OrderDao {
	
	@PersistenceContext
	EntityManager em;
	
	public boolean deleteOrder(Integer order_Id) {
		OrderInfo order = em.find(OrderInfo.class, order_Id);
		if (order != null) {
			em.remove(order);
			return true;
		} else {
			return false;
		}
	}

}
