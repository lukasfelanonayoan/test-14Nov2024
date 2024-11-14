package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cobaController {
	@GetMapping("/home")
    public String homeEndpoint() {
        return "Baeldung !";
    }
	

	@GetMapping("/home2")
	public Map<String, Object> getStatus() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("status", 200);
			map.put("message", "API Ready to Use");
			return map;
		} catch (Exception error) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpStatus statusResult = HttpStatus.BAD_GATEWAY;
			map.put("status", statusResult.value());
			map.put("exceptionMessage", error.getMessage());
			map.put("message", "Error Get Data Movie");
			return map;
		}
	}
}
