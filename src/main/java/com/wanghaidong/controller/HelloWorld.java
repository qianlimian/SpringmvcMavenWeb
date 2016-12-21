package com.wanghaidong.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wanghaidong.entity.User;

@Controller
public class HelloWorld {

	private static final String SUCCESS="success";
	//WEB-INF目录下不能直接转发吗？
	@RequestMapping("testRedirect")
	public String testRedirect(){
		System.out.println("testRedirect!");
		return "forward:/static/index.jsp";
	}
	@RequestMapping("testView")
	public String testView(){
		System.out.println("testView!!");
		return "helloView";
	}
	
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,
			Map<String,Object> map){
		System.out.println("ModelAttribute!!");
		if(id != null){
			System.out.println("Emulate Database Operation!!");
			User user = new User(1, "lily", "123456", "lily@sina.com", 25);
			System.out.println("Data: " + user);
			map.put("user", user);
		}
	}
	@RequestMapping(value="testModelAttribute",method=RequestMethod.POST)
	public String testModelAttribute(User user){
		System.out.println("testModelAttribute : "+user);
		return SUCCESS;
	}
	@RequestMapping("testMap")
	public String testMap(Map<String,Object> map){
		map.put("name", Arrays.asList("zhangsan","lisi","wanger"));
		//map.put("name", new String[]{"zhangsan","lisi","wangerzhuang"});
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
		System.out.println("GET");
		return SUCCESS;
	}
	@RequestMapping(value="testREST",method=RequestMethod.POST)
	public String testPOST(){
		System.out.println("POST");
		return SUCCESS;
	}
	//不能直接return SUCCESS ??
	@RequestMapping(value="testREST/{id}",method=RequestMethod.DELETE)
	public String testDelete(@PathVariable(value="id") Integer id){
		System.out.println("DELETE");
		return "redirect:/helloWorld";
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
	
	/************************************************************************************************/
	/**
	 * 测试页面的入口
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016年12月21日 下午3:23:04
	 */
	@RequestMapping(value="test",method=RequestMethod.GET)
	public String testPage(){
		return "testPage";
	}
	
}
