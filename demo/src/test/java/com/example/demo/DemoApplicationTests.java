package com.example.demo;

import com.example.demo.Entity.*;
import com.example.demo.Repository.DescriptionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DescriptionRepository descriptionRepository;

	@Test
	void contextLoads() {


	}

}
