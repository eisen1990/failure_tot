package com.example.chipmngt.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.chipmngt.dto.CustomerDTO;
import com.example.chipmngt.dto.DeviceDTO;

public class CJSON {
	public JSONArray CustomerToJSON(List<CustomerDTO> list) {
		JSONArray result = new JSONArray();
		for (CustomerDTO customerDTO : list) {
			JSONObject elem = new JSONObject();
			elem.put("id", customerDTO.getId() );
			elem.put("tc_customer", customerDTO.getTcCustomer() );
			elem.put("end_customer", customerDTO.getEndCustomer() );
			result.add(elem);
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
