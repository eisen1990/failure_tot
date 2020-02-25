package com.example.chipmngt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chipmngt.dao.DeviceDAO;
import com.example.chipmngt.dto.DeviceDTO;

import jdk.internal.jline.internal.Log;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceDAO deviceDAO;

	@Override
	public List<DeviceDTO> getDevices() {
		List<DeviceDTO> result = null;
		try {
			result = deviceDAO.selectDevices();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean putDevice(DeviceDTO dDTO) {
		boolean flag = false;
		try {
			deviceDAO.insertDevice(dDTO);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean modifyDevice(DeviceDTO dDTO) {
		boolean flag = false;
		try {
			deviceDAO.updateDevice(dDTO);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean removeDevice(Integer id) {
		boolean flag = false;
		try {
			deviceDAO.deleteDevice(id);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
}
