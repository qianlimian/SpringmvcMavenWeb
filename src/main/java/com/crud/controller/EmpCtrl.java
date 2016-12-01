package com.crud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.dao.EmployeeDao;

@Controller
public class EmpCtrl {
	@Autowired
	private EmployeeDao employeeDao;
	@RequestMapping("crud")
	public String crud(Map<String,Object> map){
		map.put("employees",employeeDao.getAll() );
		return "emps";
	}
}
