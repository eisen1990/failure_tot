package com.example.chipmngt.dto;

public class CustomerDTO {
	private Integer id;
	private String tcCustomer;
	private String endCustomer;
	
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
		return "CustomerDTO [id="+id+", tcCustomer="+tcCustomer+", endCustomer="+endCustomer+"]";
	}
}
