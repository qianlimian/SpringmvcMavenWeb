package com.crud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.dao.DepartmentDao;
import com.crud.dao.EmployeeDao;
import com.crud.entities.Employee;

@Controller
public class EmpCtrl {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	@RequestMapping("crud")
	public String crud(Map<String,Object> map){
		map.put("employees",employeeDao.getAll() );
		return "emps";
	}
	@RequestMapping("emp")
	public String emp(Map<String,Object> map){
		map.put("departments", departmentDao.getAll());
		Employee employee = new Employee();
		map.put("employee", employee);
		return "emp";
	}
}
