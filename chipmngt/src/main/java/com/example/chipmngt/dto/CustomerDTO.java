package com.example.chipmngt.dto;

public class CustomerDTO {
	private Integer id;
	private String customer;
	private String tcCustomer;
	private String endCustomer;

	public CustomerDTO() {
		
	}
	
	public CustomerDTO(String customer, String tcCustomer, String endCustomer) {
		this.id = null;
		this.customer = customer;
		this.tcCustomer = tcCustomer;
		this.endCustomer = endCustomer;
	}
	
	public CustomerDTO(int id, String customer, String tcCustomer, String endCustomer) {
		this.id = id;
		this.customer = customer;
		this.tcCustomer = tcCustomer;
		this.endCustomer = endCustomer;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTcCustomer() {
		return tcCustomer;
	}

	public void setTcCustomer(String tcCustomer) {
		this.tcCustomer = tcCustomer;
	}

	public String getEndCustomer() {
		return endCustomer;
	}

	public void setEndCustomer(String endCustomer) {
		this.endCustomer = endCustomer;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", customer=" + customer + ", tcCustomer=" + tcCustomer + ", endCustomer=" + endCustomer + "]";
	}
}
