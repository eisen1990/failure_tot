package com.example.chipmngt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.chipmngt.configservice.TestService;

@SpringBootApplication
public class ChipmngtApplication implements CommandLineRunner {

	@Autowired
	private TestService testService;
	
	public static void main(String[] args) {
		SpringApplication.run(ChipmngtApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		testService.uri_print();
	}
}
