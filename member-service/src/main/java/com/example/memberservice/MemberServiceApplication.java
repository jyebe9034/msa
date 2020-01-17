package com.example.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableFeignClients
public class MemberServiceApplication {

	@Autowired
	private RsvClient rsvClient;

	@GetMapping("/member")
	public ResponseEntity<Map<String, Object>> memberinfo() {
		Map<String, Object> map = new HashMap<>();
		map.put("question", "what time is it?");
		map.put("answer", "It's 1:15");
		map.put("rsvinfo", rsvClient.rsvinfo());

		return ResponseEntity.ok(map);
	}

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}

}
