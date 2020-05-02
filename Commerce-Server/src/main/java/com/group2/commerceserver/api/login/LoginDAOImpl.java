package com.group2.commerceserver.api.login;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.group2.commerceserver.models.Login;
import com.group2.commerceserver.models.User;
import com.group2.commerceserver.rowmappers.UserRowMapper;
import com.group2.commerceserver.sql.LoginSql;

@Service
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public LoginDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public User signin(Login login) {
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("username", login.getUsername())
				.addValue("password", login.getPassword());
		User user = new User();
		try {
			user = namedParameterJdbcTemplate.query(LoginSql.CHECK_LOGIN, paramSource, new UserRowMapper()).get(0);
		}
		catch(Exception e) {
			user.setUserID(0);
		}
		return user;
		
	}

}
