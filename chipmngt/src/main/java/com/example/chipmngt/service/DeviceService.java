package com.example.chipmngt.service;

import java.util.List;

import com.example.chipmngt.dto.DeviceDTO;

public interface DeviceService {
	public List<DeviceDTO> getDevices();
	public boolean putDevice(DeviceDTO dDTO);
	public boolean modifyDevice(DeviceDTO dDTO);
	public boolean removeDevice(Integer id);
}
