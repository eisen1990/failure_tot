package com.example.chipmngt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/")
public class ContentController {

	@RequestMapping
	public ModelAndView mainView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");

		System.out.println("mainView");
		return mav;
	}

}
