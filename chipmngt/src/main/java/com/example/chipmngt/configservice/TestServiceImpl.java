package com.example.chipmngt.configservice;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private ApplicationContext ac;
	
	@Override
	public void uri_print() {
		// TODO Auto-generated method stub
		System.out.println("TestService Running");
		

		RequestMappingHandlerMapping mapping = ac.getBean(RequestMappingHandlerMapping.class);

		Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

		int i = 0;
		for (Entry<RequestMappingInfo, HandlerMethod> elem : map.entrySet()) {
			RequestMappingInfo key = elem.getKey();
			
			System.out.println("path[" + i + "] : " + key.getPatternsCondition().getPatterns().toArray()[0].toString());
			i++;
		}
	}
}
