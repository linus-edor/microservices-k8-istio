package com.boot.microservice.callme.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contoller {

	@GetMapping("/callme")
	public String callmeResponse(){
		try {
			return "Response from callme @ address:: " + InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "There was an error getting the hostname.";
	}
	
}
