package com.example.chipmngt.service;

import java.util.List;

import com.example.chipmngt.dto.DeviceDTO;

public interface DeviceService {
	public List<DeviceDTO> getDevices() throws Exception;
	public void putDevice(DeviceDTO dDTO) throws Exception;
}
