package com.example.chipmngt.dto;

public class DeviceDTO {
	private Integer id;
	private String device_name;
	private String device_full;
	private String family;
	private Integer icode;

	public DeviceDTO(String device_full, String family) {
		this.device_full = device_full;
		this.family = family;
	}
	
	public DeviceDTO(Integer id, String device_name, String device_full, String family) {
		this.id = id;
		this.device_name = device_name;
		this.device_full = device_full;
		this.family = family;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public String getDevice_full() {
		return device_full;
	}

	public void setDevice_full(String device_full) {
		this.device_full = device_full;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public Integer getIcode() {
		return icode;
	}

	public void seticode(Integer icode) {
		this.icode = icode;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", device_name=" + device_name + ", device_full=" + device_full + ", family=" + family + ", icode=" + icode + "]";
	}
}
