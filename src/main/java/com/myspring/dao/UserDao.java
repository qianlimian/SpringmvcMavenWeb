package com.myspring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myspring.entity.User;

@Repository
public class UserDao implements UserDaoImpl{
	@Autowired
	@Qualifier("DBCPDataSource")
	private DataSource dataSource;
	/**
	 * 使用jdbc模板插入数据
	 */
	@Autowired
	private JdbcOperations jdbcOperations;
	/**
	 * 增加一个User
	 */
	@Override
	public void insertUser(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = dataSource.getConnection();
			String sql = "insert into tb_user (name,age,sex) values (?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setInt(2, user.getAge());
			stmt.setString(3, user.getSex());
			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try{
				
				stmt.close();
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 根据id查找,jdbcTemplate实现
	 */
	@Override
	public User findOne(Integer id) {
		String sql = "select id,name,age,sex from tb_user where id = ?";
		return jdbcOperations.queryForObject(sql, new UserRowMapper(),id);
		
	}
	private static final class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("sex"));
		}
		
	}
	/**
	 * 添加用户，jdbcTemplate实现
	 */
	@Override
	public void addUser(User user) {
		String sql = "insert into tb_user (name,age,sex) values (?,?,?)";
		jdbcOperations.update(sql,user.getName(),user.getAge(),user.getSex());
		
	}
	

}
