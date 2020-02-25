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

@Controller
@RequestMapping(value = "/shipment")
public class ShipmentController {
		
	@Autowired
	private DeviceService DeviceService;
	
	@RequestMapping
	public ModelAndView viewCustomerList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customer/view");
		
		return mav;
	}
	
	@RequestMapping(value = "/list")
	@ResponseBody
	public JSONObject getCustomersAPI() {
		JSONObject result = new JSONObject();
		List<DeviceDTO> list = new ArrayList<DeviceDTO>();
		
		try {
			list = DeviceService.getDevices();
//			JSONArray jsonList = cJSON.DeviceToJSON(list);
			result.put("result", "pass");
//			result.put("list", jsonList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result", "error");
		}
		return result;
	}
	

}
