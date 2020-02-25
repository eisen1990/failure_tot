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
		List<CustomerDTO> result = null;
		try {
			result = customerDAO.selectCustomers();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		return result;
	}
	
	@Override
	public boolean putCustomer(CustomerDTO cDTO) {
		boolean flag = false;
		try {
			customerDAO.insertCustomer(cDTO);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
	
	@Override
	public boolean modifyCustomer(CustomerDTO cDTO) {
		boolean flag = false;
		try {
			customerDAO.updateCustomer(cDTO);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
	
	@Override
	public boolean removeCustomer(Integer id) {
		boolean flag = false;
		try {
			customerDAO.deleteCustomer(id);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
}
