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

import com.example.chipmngt.dto.CustomerDTO;
import com.example.chipmngt.service.CustomerService;
import com.example.chipmngt.utils.CJSON;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
		
	@Autowired
	private CustomerService customerService;
	
	private CJSON cJSON = new CJSON();
	
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
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();
		
		try {
			list = customerService.getCustomers();
			JSONArray jsonList = cJSON.CustomerToJSON(list);
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
	public JSONObject putCustomerAPI(HttpServletRequest req) {
		JSONObject result = new JSONObject();
		CustomerDTO cDTO = new CustomerDTO();
		
		String tcCustomer = req.getParameter("tc_customer");
		String endCustomer = req.getParameter("end_customer");
		
		cDTO.setTcCustomer(tcCustomer);
		cDTO.setEndCustomer(endCustomer);
		
		System.out.println(cDTO.toString());
		
		try {
			customerService.putCustomer(cDTO);
			result.put("result", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result", "error");
		}
		
		return result;
	}
}
