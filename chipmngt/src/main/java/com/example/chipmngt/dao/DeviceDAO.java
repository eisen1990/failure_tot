package com.example.chipmngt.dao;

import java.util.List;

import com.example.chipmngt.dto.DeviceDTO;

public interface DeviceDAO {
	public void insertDevice(DeviceDTO dDTO) throws Exception;
	public List<DeviceDTO> selectDevices() throws Exception;
	public void updateDevice(DeviceDTO dDTO) throws Exception;
	public void deleteDevice(Integer dDTO) throws Exception;
}
