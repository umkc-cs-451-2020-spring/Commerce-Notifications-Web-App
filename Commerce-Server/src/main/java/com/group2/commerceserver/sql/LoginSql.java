package com.group2.commerceserver.sql;

public class LoginSql {
	public static final String CHECK_LOGIN = 
			"SELECT UserID, Username " +
			"FROM CommerceDB.User " +
			"WHERE Username = :username AND Password = md5(:password) " +
			"LIMIT 1;";
}
