package org.lanqiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.lanqiao.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @Select("SELECT * FROM User;")
    @Results(value = {@Result(id = true, column = "id", property = "id"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "password", property = "password")})
    List<User> getAll();

    // ---------------------------- 分页 ----------------------------
    @Select("select * from User " +
            "order by id desc limit #{0}, #{1}")
    List<User> getByPage(int pageNum, int pageSize);

    @Select("select count(*) from User")
    int getTotalRecordCounts();
    
    User checkUser(User user);
    
    @SelectProvider(type=UserSqlProvider.class, method="findUserByIdSql")
    User findUserByIdSql(int uid);
    
	@SelectProvider(type = UserSqlProvider.class, method = "findUserByNameAndPasswordSql")
	User findUserByNameAndPasswordSql(String name, String password);

}