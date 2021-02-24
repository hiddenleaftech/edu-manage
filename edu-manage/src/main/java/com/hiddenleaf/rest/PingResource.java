package com.hiddenleaf.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/")
public class PingResource {
	
	@GetMapping("/ping")
	Map<String, String> checkPing() {
		Map<String, String> status = new HashMap<String, String>();
		status.put("status", "up");
		return status;
	}

}
