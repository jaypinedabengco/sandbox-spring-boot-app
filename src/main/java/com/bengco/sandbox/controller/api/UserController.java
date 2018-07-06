package com.bengco.sandbox.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bengco.sandbox.model.Test;

@RestController
@RequestMapping("/api")
public class UserController {

	@RequestMapping(method=RequestMethod.GET, value="/test")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/test2")
	public String hello2() {
		return "helloxxx";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getallTests")
	public List<Test> helloTest() {
		return new ArrayList<Test>();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addTest")
	public void addTest(@RequestBody Test test) {		
	}
}
