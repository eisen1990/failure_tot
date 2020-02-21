package com.example.chipmngt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.chipmngt.dao.DeviceDAO;
import com.example.chipmngt.dto.DeviceDTO;

public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceDAO deviceDAO;
	
	@Override
	public List<DeviceDTO> getDevices() throws Exception {
		List<DeviceDTO> result = deviceDAO.selectDevices(); 
		return result;
	}

	@Override
	public void putDevice(DeviceDTO dDTO) throws Exception {
		deviceDAO.insertDevice(dDTO);
	}

}
