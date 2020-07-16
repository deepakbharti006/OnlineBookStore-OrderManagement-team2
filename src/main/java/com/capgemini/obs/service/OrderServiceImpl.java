package com.capgemini.obs.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.obs.dao.OrderDao;
import com.capgemini.obs.exception.OrderException;

@Transactional
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDao orderDao;

	@Override
	public String deleteOrder(Integer order_Id) throws OrderException {
		if (orderDao.deleteOrder(order_Id))
			return "Order Deleted";
		else
			throw new OrderException("Order not found.");

	}
	
	

}
