package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaAuditing
public class DemoApplication {

public static void main(String[] args) {
SpringApplication.run(DemoApplication.class, args);
}

//@GetMapping("/hello")
//public String hello(@RequestParam(value = "name", defaultValue = "World Simon") String name) {
//return String.format("Hello %s!", name);
//}
}
