package com.example.chipmngt.dao;

import java.util.List;

import com.example.chipmngt.dto.DeviceDTO;

public interface DeviceDAO {
	public void insertDevice(DeviceDTO dDTO);
	public List<DeviceDTO> selectDevices();
	public void updateDevice(DeviceDTO dDTO);
	public void deleteDevice(Integer dDTO);
}
