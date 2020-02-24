package com.example.chipmngt.dto;

public class DeviceDTO {
	private Integer id;
	private String device;
	private String family;

	public DeviceDTO() {
		
	}
	
	public DeviceDTO(String device, String family) {
		this.id = null;
		this.device = device;
		this.family = family;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", device=" + device + ", family=" + family + "]";
	}
}
