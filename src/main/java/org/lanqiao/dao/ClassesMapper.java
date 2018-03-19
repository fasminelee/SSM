package org.lanqiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.lanqiao.entity.Classes;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
    
    @Select("SELECT * FROM Classes;")
    @Results(value = {@Result(id = true, column = "id", property = "id"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "password", property = "password")})
    List<Classes> getAll();

    // ---------------------------- 分页 ----------------------------
    @Select("select * from Classes " +
            "order by id desc limit #{0}, #{1}")
    List<Classes> getByPage(int pageNum, int pageSize);

    @Select("select count(*) from Classes")
    int getTotalRecordCounts();
}