package com.myspring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.myspring.entity.User;

public interface AutoJpaUserRepository extends CrudRepository<User,Integer>{
	/**
	 * �����������в���
	 * @description
	 * @return User
	 * @author wanghaidong
	 * @date 2016��12��15�� ����4:59:09
	 */
	User findByName(String name);
	/**
	 * �����������ĳ��ֵ���û�
	 * @description
	 * @return List<User>
	 * @author wanghaidong
	 * @date 2016��12��15�� ����5:00:32
	 */
	List<User> findByAgeGreaterThan(Integer age);
	@Query("select u from User u where u.name = :str")
	User findSomeSpecial(@Param("str") String str);
}
