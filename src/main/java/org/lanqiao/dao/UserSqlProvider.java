package org.lanqiao.dao;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {


	public String findUserByIdSql(final int uid) {

		return new SQL() {
			{
				SELECT("uid, name, email, birthday, age");
				FROM("User");
				WHERE("uid=" + uid);
			}
		}.toString();
	}
	
	public String findUserByNameAndPasswordSql(Map<String, Object> map) {
		String name = (String) map.get("param1");
		String email = (String) map.get("param2");
		// you can also get those values using 0,1 keys
		// String name = (String) map.get("0");
		// String email = (String) map.get("1");
		return new SQL() {
			{
				SELECT("uid, name, email, birthday, age");
				FROM("User");
				WHERE("name=#{name} AND password=#{email}");
			}
		}.toString();
	}
}
