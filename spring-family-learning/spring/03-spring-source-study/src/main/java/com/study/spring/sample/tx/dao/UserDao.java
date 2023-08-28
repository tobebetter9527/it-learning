package com.study.spring.sample.tx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.study.spring.sample.tx.entity.User;

//@Mapper
@Component
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// @Insert("insert t_user(id,user_name) values(#{id},#{userName})")
	public void insert(User u) {
		jdbcTemplate.update("insert t_user(id,user_name) values(?,?)", u.getId(), u.getUserName());
	}

	// @Update("update t_user set user_name = #{userName} where id=#{id} ")
	public void update(User u) {
		jdbcTemplate.update("update t_user set user_name = ? where id= ?", u.getUserName(), u.getId());
	}

	// @Delete("delete from t_user where id=#{id} ")
	public void delete(String id) {
		jdbcTemplate.update("delete from t_user where id= ?", id);
	}

	// @Select("select id,user_name from t_user where id=#{id} ")
	public User find(String id) {
		return jdbcTemplate.query("select id,user_name from t_user where id= ?", new Object[] { id },
				new ResultSetExtractor<User>() {

					@Override
					public User extractData(ResultSet rs) throws SQLException, DataAccessException {
						if (rs.next()) {
							User user = new User();
							user.setId(rs.getString(1));
							user.setUserName(rs.getString(2));
							return user;
						}
						return null;
					}

				});
	}

}
