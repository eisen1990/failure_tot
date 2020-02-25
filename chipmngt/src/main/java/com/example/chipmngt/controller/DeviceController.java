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

	@PostMapping(value = "/post/{device}/{family}")
	@ResponseBody
	public JSONObject postDeviceAPI(
			@PathVariable("device_full") String device_full,
			@PathVariable("family") String family) {
		JSONObject result = new JSONObject();
		DeviceDTO dDTO = new DeviceDTO(device_full, family);

		System.out.println(dDTO.toString());

		// device_name : TCCXXXX, TCMXXXX, AD55 로 자르는 루틴
		//dDTO.setDevice_name();
		// icode : 마지막이 i인지 검사하는 루틴
		//dDTO.seticode();
		
//		result.put("result", deviceService.putDevice(dDTO));

		return result;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public JSONObject getDevicesAPI() {
		JSONObject result = new JSONObject();
		List<DeviceDTO> list = new ArrayList<DeviceDTO>();

		list = deviceService.getDevices();
		if (list == null) {
			result.put("result", false);
			result.put("list", null);
		} else {
			JSONArray jsonList = DeviceToJSON(list);
			result.put("result", true);
			result.put("list", jsonList);
		}

		return result;
	}

	@PutMapping(value = "/{id}/{device_name}/{device_full}/{family}")
	@ResponseBody
	public JSONObject putDeviceAPI(
			@PathVariable("id") int id, 
			@PathVariable("device_name") String device_name,
			@PathVariable("device_full") String device_full,
			@PathVariable("family") String family) {
		JSONObject result = new JSONObject();
		DeviceDTO dDTO = new DeviceDTO(id, device_name, device_full, family);

		System.out.println(dDTO.toString());

		result.put("result", deviceService.modifyDevice(dDTO));

		return result;
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public JSONObject putDeviceAPI(@PathVariable("id") int id) {
		JSONObject result = new JSONObject();

		System.out.println("id=" + id);

		result.put("result", deviceService.removeDevice(id));

		return result;
	}

	public JSONArray DeviceToJSON(List<DeviceDTO> list) {
		JSONArray result = new JSONArray();
		for (DeviceDTO deviceDTO : list) {
			JSONObject elem = new JSONObject();
			elem.put("id", deviceDTO.getId());
			elem.put("device_name", deviceDTO.getDevice_name());
			elem.put("device_full", deviceDTO.getDevice_full());
			elem.put("family", deviceDTO.getFamily());
			elem.put("icode", deviceDTO.getIcode());
			result.add(elem);
		}
		return result;
	}
}
