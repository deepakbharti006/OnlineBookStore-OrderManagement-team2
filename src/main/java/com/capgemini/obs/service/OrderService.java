package com.capgemini.obs.service;

import com.capgemini.obs.exception.OrderException;

public interface OrderService {
	
	String deleteOrder(Integer order_Id) throws OrderException;

}
