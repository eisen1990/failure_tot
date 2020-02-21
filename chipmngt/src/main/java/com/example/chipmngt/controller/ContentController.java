package com.example.chipmngt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.chipmngt.service.CustomerService;

@Controller
@RequestMapping(value = "/")
public class ContentController {
		
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/")
	public ModelAndView mainView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");

		System.out.println("mainView");
		return mav;
	}

}
