package com.example.chipmngt.service;

import java.util.List;

import com.example.chipmngt.dto.CustomerDTO;

public interface CustomerService {
	public List<CustomerDTO> getCustomers() throws Exception;
	public void putCustomer(CustomerDTO cDTO) throws Exception;
}
