package com.boot.microservice.caller.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

	@Autowired
	RestTemplate tmp;
	
	@GetMapping("/call-backend")
	public String callBackend() {
		String response = tmp.getForObject("http://192.168.1.184:31380/callme", String.class);
		try {
			return "Response from backend::: " + response + " :::::: own address::: " + InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "An error occured!!";
	}
}
