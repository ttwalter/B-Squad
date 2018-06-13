package com.nm.jaguar.shark.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MatchController {
	
	@RequestMapping("/FindExistingMatches")
	public String findExistingMatches() {
		return "Jaguar Shark";
	}

}
