package org.lanqiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.lanqiao.entity.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    @Select("SELECT * FROM Teacher;")
    @Results(value = {@Result(id = true, column = "id", property = "id"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "password", property = "password")})
    List<Teacher> getAll();

    // ---------------------------- 分页 ----------------------------
    @Select("select * from Teacher " +
            "order by id desc limit #{0}, #{1}")
    List<Teacher> getByPage(int pageNum, int pageSize);

    @Select("select count(*) from Teacher")
    int getTotalRecordCounts();
}