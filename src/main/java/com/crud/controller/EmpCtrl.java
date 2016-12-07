package com.crud.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
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
	 * 显示所有员工的列表
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016年12月3日 上午9:09:32
	 */
	@RequestMapping("crud")
	public String crud(Map<String,Object> map){
		map.put("employees",employeeDao.getAll() );
		return "emps";
	}
	/**
	 * 添加员工的页面
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016年12月3日 上午8:33:55
	 */
	@RequestMapping("emp")
	public String emp(Map<String,Object> map){
		map.put("departments", departmentDao.getAll());
		Employee employee = new Employee();
		map.put("employee", employee);
		return "emp";
	}
	/**
	 * 新增员工
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016年12月3日 上午9:10:44
	 */
	//这里的第二个参数必须是Errors类型，如果写成BindingResult类型，是不能回显的
	//也就是用户填写的employee是不能添加到请求域中的
	@RequestMapping(value="emp",method=RequestMethod.POST)
	public String addEmployee(@Valid Employee employee,Errors result,Map<String,Object> map) {
		//如果不进行错误的处理，当转化不成功的时候，就会直接报错
		if(result.getErrorCount()>0){
			System.out.println("出错了");
			for(FieldError error : result.getFieldErrors()){
				System.out.println(error.getField()+" : "+error.getDefaultMessage());
				map.put("departments", departmentDao.getAll());
				return "emp";
			}
		}
		System.out.println("Save: "+employee);
		employeeDao.save(employee);
		return "forward:/crud";
	}
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") Integer id){
		employeeDao.delete(id);
		return "redirect:/crud";
	}
	/**
	 * 编辑员工的页面
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016年12月3日 上午8:37:00
	 */
	@RequestMapping(value="edit/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable(value="id") Integer id,Map<String,Object> map){
		Employee employee = employeeDao.get(id);
		map.put("employee", employee);
		map.put("departments", departmentDao.getAll());
		return "emp";
	}
	/**
	 * 修改员工信息
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016年12月3日 上午9:19:12
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
	/**
	 * 测试自定义的类型转换器
	 * ConvertService
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016年12月5日 下午1:50:27
	 */
	@RequestMapping("testConverter")
	public String testConvertService(@RequestParam("employee") Employee employee){
		employeeDao.save(employee);
		return "redirect:/crud";
	}
	/**
	 * InitBinder
	 * @description
	 * @return void
	 * @author wanghaidong
	 * @date 2016年12月6日 上午8:25:28
	 */
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		binder.setDisallowedFields("lastName");
//	}
}
