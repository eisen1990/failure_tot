package com.example.chipmngt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.chipmngt.dto.DeviceDTO;
import com.example.chipmngt.service.DeviceService;
import com.example.chipmngt.utils.CJSON;

@Controller
@RequestMapping(value = "/device")
public class DeviceController {
		
	@Autowired
	private DeviceService DeviceService;
	
	private CJSON cJSON = new CJSON();
	
	@RequestMapping
	public ModelAndView viewDeviceList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customer/view");
		
		return mav;
	}
	
	@RequestMapping(value = "/list")
	@ResponseBody
	public JSONObject getDevicesAPI() {
		JSONObject result = new JSONObject();
		List<DeviceDTO> list = new ArrayList<DeviceDTO>();
		
		try {
			list = DeviceService.getDevices();
			JSONArray jsonList = cJSON.DeviceToJSON(list);
			result.put("result", "pass");
			result.put("list", jsonList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result", "error");
		}
		return result;
	}
	
	@PostMapping(value = "/insert")
	@ResponseBody
	public JSONObject putDeviceAPI(HttpServletRequest req) {
		JSONObject result = new JSONObject();
		DeviceDTO dDTO = new DeviceDTO();
		
		String device = req.getParameter("device");
		String family = req.getParameter("family");
		
		dDTO.setDevice(device);
		dDTO.setFamily(family);
		
		System.out.println(dDTO.toString());
		
		try {
			DeviceService.putDevice(dDTO);
			result.put("result", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result", "error");
		}
		
		return result;
	}
}
