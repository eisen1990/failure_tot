package com.example.chipmngt.dao;

import java.util.List;

import com.example.chipmngt.dto.CustomerDTO;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cDTO);
	public List<CustomerDTO> selectCustomers();
	public void updateCustomer(CustomerDTO cDTO);
	public void deleteCustomer(Integer cDTO);
}
