package com.wanghaidong.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wanghaidong.entity.User;

@Controller
public class HelloWorld {

	private static final String SUCCESS="success";
	@RequestMapping("testMap")
	public String testMap(Map<String,Object> map){
		//map.put("name", Arrays.asList("zhangsan","lisi","wanger"));
		map.put("name", new String[]{"zhangsan","lisi","wangerzhuang"});
		return SUCCESS;
	}
	@RequestMapping("testModelAndView")
	public ModelAndView testModelAndView(){
		ModelAndView mav = new ModelAndView(SUCCESS);
		mav.addObject("time", new Date());
		return mav;
	}
	@RequestMapping(value="testPOJO",method=RequestMethod.POST)
	public String testPOJO(User user){
		System.out.println("testPOJO: "+ user);
		return SUCCESS;
	}
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
	@RequestMapping(value="testRequestParam",method=RequestMethod.GET)
	public String testRequestParam(@RequestParam(value="name",required=false,defaultValue="wanghaidong") String name){
		System.out.println("My name is " + name);
		return SUCCESS;
	}
	
}
