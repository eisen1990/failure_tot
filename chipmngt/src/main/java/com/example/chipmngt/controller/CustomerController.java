package com.example.chipmngt.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.chipmngt.dto.CustomerDTO;
import com.example.chipmngt.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
		
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping
	public ModelAndView viewCustomerList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customer/view");
		
		return mav;
	}
	
	@PostMapping(value = "/{tc_customer}/{end_customer}")
	@ResponseBody
	public JSONObject postCustomerAPI(
			@PathVariable("tc_customer") String tc_customer,
			@PathVariable("end_customer") String end_customer
			) {
		JSONObject result = new JSONObject();
		CustomerDTO cDTO = new CustomerDTO(tc_customer, end_customer);
		System.out.println(cDTO.toString());
		
		try {
			customerService.putCustomer(cDTO);
			result.put("result", "pass");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", "error");
		}
		return result;
	}
	
	@GetMapping(value = "/list")
	@ResponseBody
	public JSONObject getCustomersAPI() {
		JSONObject result = new JSONObject();
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();
		
		try {
			list = customerService.getCustomers();
			JSONArray jsonList = CustomerToJSON(list);
			result.put("result", "pass");
			result.put("list", jsonList);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", "error");
		}
		return result;
	}
	
	@PutMapping(value = "/{id}/{tc_customer}/{end_customer}")
	@ResponseBody
	public JSONObject putCustomerAPI(
			@PathVariable("id") int id,
			@PathVariable("tc_customer") String tc_customer,
			@PathVariable("end_customer") String end_customer
			) {
		JSONObject result = new JSONObject();
		CustomerDTO cDTO = new CustomerDTO(tc_customer, end_customer);
		System.out.println(cDTO.toString());
		
		try {
			customerService.modifyCustomer(cDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public JSONObject deleteCustomerAPI(
			@PathVariable("id") int id
			) {
		JSONObject result = new JSONObject();
		
		try {
			customerService.removeCustomer(id);
			result.put("result", "pass");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", "error");
		}
		
		return result;
	}	
	
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
	
}
