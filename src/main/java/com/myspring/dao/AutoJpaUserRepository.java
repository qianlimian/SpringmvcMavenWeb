package com.myspring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.myspring.entity.User;

public interface AutoJpaUserRepository extends CrudRepository<User,Integer>{
	/**
	 * 根据姓名进行查找
	 * @description
	 * @return User
	 * @author wanghaidong
	 * @date 2016年12月15日 下午4:59:09
	 */
	User findByName(String name);
	/**
	 * 查找年龄大于某个值得用户
	 * @description
	 * @return List<User>
	 * @author wanghaidong
	 * @date 2016年12月15日 下午5:00:32
	 */
	List<User> findByAgeGreaterThan(Integer age);
	@Query("select u from User u where u.name = :str")
	User findSomeSpecial(@Param("str") String str);
}
