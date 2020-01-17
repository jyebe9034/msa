package com.example.rsvservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@Slf4j
public class RsvServiceApplication {

	@Autowired
	private Environment environment;

	@GetMapping("/rsvinfo")
	public ResponseEntity<Map<String, Object>> rsvinfo() {
		log.info("port: " + environment.getProperty("server.port"));
		Map<String, Object> map = new HashMap<>();
		map.put("question", "Have you ever been to Portugal");
		map.put("answer", "Yes, I've been there four years ago.");

		return ResponseEntity.ok(map);
	}

	public static void main(String[] args) {
		SpringApplication.run(RsvServiceApplication.class, args);
	}

}
