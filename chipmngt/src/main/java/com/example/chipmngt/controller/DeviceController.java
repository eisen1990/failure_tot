package com.example.chipmngt.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.chipmngt.dto.DeviceDTO;
import com.example.chipmngt.service.DeviceService;

@Controller
@RequestMapping(value = "/device")
public class DeviceController {
		
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping
	public ModelAndView viewDeviceList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("device/view");
		
		return mav;
	}
	
	@PostMapping(value = "/{device}/{family}")
	@ResponseBody
	public JSONObject putDeviceAPI(
			@PathVariable("device") String device,
			@PathVariable("family") String family
			) {
		JSONObject result = new JSONObject();
		DeviceDTO dDTO = new DeviceDTO(device, family);
		
		System.out.println(dDTO.toString());
		
		try {
			deviceService.putDevice(dDTO);
			result.put("result", "pass");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", "error");
		}
		
		return result;
	}
	
	@RequestMapping(value = "/list")
	@ResponseBody
	public JSONObject getDevicesAPI() {
		JSONObject result = new JSONObject();
		List<DeviceDTO> list = new ArrayList<DeviceDTO>();
		
		try {
			list = deviceService.getDevices();
			JSONArray jsonList = DeviceToJSON(list);
			result.put("result", "pass");
			result.put("list", jsonList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result", "error");
		}
		return result;
	}
	
	@PutMapping(value="/{id}/{device}/{family}")
	@ResponseBody
	public JSONObject putDeviceAPI(
			@PathVariable("id") int id,
			@PathVariable("device") String device,
			@PathVariable("family") String family
			) {
		JSONObject result = new JSONObject();
		DeviceDTO dDTO = new DeviceDTO(device, family);
		
		try {
			deviceService.modifyDevice(dDTO);
			result.put("result", "pass");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", "error");
		}
		
		return result;
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseBody
	public JSONObject putDeviceAPI(
			@PathVariable("id") int id
			) {
		JSONObject result = new JSONObject();
		
		try {
			deviceService.removeDevice(id);
			result.put("result", "pass");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", "error");
		}
		
		return result;
	}
	

	
	public JSONArray DeviceToJSON(List<DeviceDTO> list) {
		JSONArray result = new JSONArray();
		for (DeviceDTO deviceDTO : list) {
			JSONObject elem = new JSONObject();
			elem.put("id", deviceDTO.getId() );
			elem.put("device", deviceDTO.getDevice() );
			elem.put("family", deviceDTO.getFamily() );
			result.add(elem);
		}
		return result;
	}
}
