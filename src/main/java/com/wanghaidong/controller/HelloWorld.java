package com.wanghaidong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorld {

	private static final String SUCCESS="success";
	@RequestMapping("helloWorld")
	public String helloWorld(){
		System.out.println("helloWorld!!");
		return SUCCESS;
	}
	@RequestMapping("testREST/{id}")
	public String testPathVariable(@PathVariable(value="id") Integer id){
		System.out.println("GET:id = "+id);
		return SUCCESS;
	}
	@RequestMapping(value="testREST",method=RequestMethod.POST)
	public String testPOST(){
		System.out.println("POST");
		return SUCCESS;
	}
	@RequestMapping(value="testREST/{id}",method=RequestMethod.DELETE)
	public String testDelete(@PathVariable(value="id") Integer id){
		System.out.println("DELETE");
		return SUCCESS;
	}
	@RequestMapping(value="testREST/{id}",method=RequestMethod.PUT)
	public String testPut(@PathVariable(value="id") Integer id){
		System.out.println("PUT");
		return SUCCESS;
	}
	
}
