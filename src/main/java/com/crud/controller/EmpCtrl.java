package com.crud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.dao.DepartmentDao;
import com.crud.dao.EmployeeDao;
import com.crud.entities.Employee;

@Controller
public class EmpCtrl {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	/**
	 * ��ʾ����Ա�����б�
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016��12��3�� ����9:09:32
	 */
	@RequestMapping("crud")
	public String crud(Map<String,Object> map){
		map.put("employees",employeeDao.getAll() );
		return "emps";
	}
	/**
	 * ���Ա����ҳ��
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016��12��3�� ����8:33:55
	 */
	@RequestMapping("emp")
	public String emp(Map<String,Object> map){
		map.put("departments", departmentDao.getAll());
		Employee employee = new Employee();
		map.put("employee", employee);
		return "emp";
	}
	/**
	 * ����Ա��
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016��12��3�� ����9:10:44
	 */
	@RequestMapping(value="emp",method=RequestMethod.POST)
	public String addEmployee(Employee employee) {
		employeeDao.save(employee);
		return "forward:/crud";
	}
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") Integer id){
		employeeDao.delete(id);
		return "redirect:/crud";
	}
	/**
	 * �༭Ա����ҳ��
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016��12��3�� ����8:37:00
	 */
	@RequestMapping(value="edit/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable(value="id") Integer id,Map<String,Object> map){
		Employee employee = employeeDao.get(id);
		map.put("employee", employee);
		map.put("departments", departmentDao.getAll());
		return "emp";
	}
	/**
	 * �޸�Ա����Ϣ
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016��12��3�� ����9:19:12
	 */
	@RequestMapping(value="emp",method=RequestMethod.PUT)
	public String editEmployee(Employee employee){
		employeeDao.save(employee);
		return "redirect:/crud";
	}
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map){
		if(id != null){
			map.put("employee", employeeDao.get(id));
		}
	}
}
