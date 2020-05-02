package com.group2.commerceserver.api.login;

import com.group2.commerceserver.models.Login;
import com.group2.commerceserver.models.User;

public interface LoginDAO {
	public User signin(Login login);
}
