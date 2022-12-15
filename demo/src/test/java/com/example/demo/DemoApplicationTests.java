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

//	@Test
//	void createDescriptionTest() {
////		Description description = new Description("bmw", "3series", "330i");
//
//		User user = new User("Victoria", "12345");
//		user.setUserType("female");
//		Project project = new Project();
//		project.setUser(user);
//		ProjectProduct projectProduct = new ProjectProduct();
//		projectProduct.setProject(project);
//		Product product = new Product()
//		Description description = Description.builder().manufacturer("bmw").series("series3").model("330i").product().build();
//		descriptionRepository.save(description);
//		Assertions.assert
//	}

}
