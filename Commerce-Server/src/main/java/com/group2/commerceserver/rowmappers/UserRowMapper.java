package com.group2.commerceserver.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.group2.commerceserver.models.User;

public class UserRowMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserID(rs.getInt("UserID"));
		user.setUsername(rs.getString("Username"));
		return user;
	}
}
