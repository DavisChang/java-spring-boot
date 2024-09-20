package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	// Injecting the value from the configuration file
	@Value("${app.greeting}")
	private String greetingMessage;

	@Value("${app.version}")
	private String appVersion;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	public String hello() {
		return "Hello World";
	}

	@GetMapping("/config")
	public String printConfig() {
		return greetingMessage + " - Version: " + appVersion;
	}
}
