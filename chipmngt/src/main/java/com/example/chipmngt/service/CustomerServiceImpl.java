package com.example.chipmngt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chipmngt.dao.CustomerDAO;
import com.example.chipmngt.dto.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public List<CustomerDTO> getCustomers() {
		List<CustomerDTO> result = customerDAO.selectCustomers(); 
		return result;
	}
	
	@Override
	public void putCustomer(CustomerDTO cDTO) {
		customerDAO.insertCustomer(cDTO);
	}
}
