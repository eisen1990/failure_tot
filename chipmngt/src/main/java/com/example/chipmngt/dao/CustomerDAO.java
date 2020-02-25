package com.example.chipmngt.dao;

import java.util.List;

import com.example.chipmngt.dto.CustomerDTO;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cDTO) throws Exception;
	public List<CustomerDTO> selectCustomers() throws Exception;
	public void updateCustomer(CustomerDTO cDTO) throws Exception;
	public void deleteCustomer(Integer cDTO) throws Exception;
}
