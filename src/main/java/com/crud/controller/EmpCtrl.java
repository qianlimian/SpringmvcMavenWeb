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
	//����ĵڶ�������������Errors���ͣ����д��BindingResult���ͣ��ǲ��ܻ��Ե�
	//Ҳ�����û���д��employee�ǲ�����ӵ��������е�
	@RequestMapping(value="emp",method=RequestMethod.POST)
	public String addEmployee(@Valid Employee employee,Errors result,Map<String,Object> map) {
		//��������д���Ĵ�����ת�����ɹ���ʱ�򣬾ͻ�ֱ�ӱ���
		if(result.getErrorCount()>0){
			System.out.println("������");
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
	/**
	 * �����Զ��������ת����
	 * ConvertService
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016��12��5�� ����1:50:27
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
	 * @date 2016��12��6�� ����8:25:28
	 */
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		binder.setDisallowedFields("lastName");
//	}
}
