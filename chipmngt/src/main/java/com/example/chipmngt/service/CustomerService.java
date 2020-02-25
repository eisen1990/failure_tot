package com.example.chipmngt.service;

import java.util.List;

import com.example.chipmngt.dto.CustomerDTO;

public interface CustomerService {
	public List<CustomerDTO> getCustomers();
	public boolean putCustomer(CustomerDTO cDTO);
	public boolean modifyCustomer(CustomerDTO cDTO);
	public boolean removeCustomer(Integer id);
}
