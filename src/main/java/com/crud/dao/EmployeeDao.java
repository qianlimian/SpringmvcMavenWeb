package com.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.entities.Department;
import com.crud.entities.Employee;
@Repository
public class EmployeeDao {
	@Autowired
	private DepartmentDao departmentDto;
	private static Map<Integer,Employee> employees = null;
	static {
		employees = new HashMap<Integer, Employee>();
		employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
		employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
		employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
		employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
		employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
	}
	private static Integer initId = 1006;
	/**
	 * 新增和修改的逻辑
	 * @description
	 * @return void
	 * @author wanghaidong
	 * @date 2016年12月3日 上午9:11:33
	 */
	public void save(Employee employee){
		if(employee.getId()==null){
			employee.setId(initId++);
		}
		employee.setDepartment(departmentDto.get(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	public Employee get(Integer id){
		return employees.get(id);
	}
	public Collection<Employee> getAll(){
		return employees.values();
	}
	public void delete(Integer id){
		employees.remove(id);
	}
}
