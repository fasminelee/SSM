package org.lanqiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.lanqiao.entity.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    @Select("SELECT * FROM Message;")
    @Results(value = {@Result(id = true, column = "id", property = "id"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "password", property = "password")})
    List<Message> getAll();

    // ---------------------------- 分页 ----------------------------
    @Select("select * from Message " +
            "order by id desc limit #{0}, #{1}")
    List<Message> getByPage(int pageNum, int pageSize);

    @Select("select count(*) from Message")
    int getTotalRecordCounts();
}