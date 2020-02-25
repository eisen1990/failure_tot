package com.example.chipmngt.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping(value = "/post/{customer}/{tc_customer}/{end_customer}")
	@ResponseBody
	public JSONObject postCustomerAPI(
			@PathVariable("customer") String customer,
			@PathVariable("tc_customer") String tc_customer,
			@PathVariable("end_customer") String end_customer) {
		JSONObject result = new JSONObject();
		CustomerDTO cDTO = new CustomerDTO(customer, tc_customer, end_customer);

		System.out.println(cDTO.toString());

		result.put("result", customerService.putCustomer(cDTO));

		return result;
	}

	@GetMapping(value = "/list")
	@ResponseBody
	public JSONObject getCustomersAPI() {
		JSONObject result = new JSONObject();
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();

		list = customerService.getCustomers();

		if (list == null) {
			result.put("result", false);
			result.put("list", null);
		} else {
			JSONArray jsonList = CustomerToJSON(list);
			result.put("result", true);
			result.put("list", jsonList);
		}
		
		System.out.println(result.toJSONString());

		return result;
	}

	@PostMapping(value = "/put/{id}/{customer}/{tc_customer}/{end_customer}")
	@ResponseBody
	public JSONObject putCustomerAPI(
			@PathVariable("id") int id,
			@PathVariable("customer") String customer,
			@PathVariable("tc_customer") String tc_customer,
			@PathVariable("end_customer") String end_customer) {
		JSONObject result = new JSONObject();
		CustomerDTO cDTO = new CustomerDTO(id, customer, tc_customer, end_customer);

		System.out.println(cDTO.toString());

		result.put("result", customerService.modifyCustomer(cDTO));

		return result;
	}

	@PostMapping(value = "/delete/{id}")
	@ResponseBody
	public JSONObject deleteCustomerAPI(@PathVariable("id") int id) {
		JSONObject result = new JSONObject();

		System.out.println("id=" + id);

		result.put("result", customerService.removeCustomer(id));

		return result;
	}

	public JSONArray CustomerToJSON(List<CustomerDTO> list) {
		JSONArray result = new JSONArray();
		for (CustomerDTO customerDTO : list) {
			JSONObject elem = new JSONObject();
			elem.put("id", customerDTO.getId());
			elem.put("customer", customerDTO.getCustomer());
			elem.put("tc_customer", customerDTO.getTcCustomer());
			elem.put("end_customer", customerDTO.getEndCustomer());
			result.add(elem);
		}
		return result;
	}

}
