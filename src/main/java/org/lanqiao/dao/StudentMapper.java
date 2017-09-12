package org.lanqiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.lanqiao.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    @Select("SELECT * FROM Student;")
    @Results(value = {@Result(id = true, column = "id", property = "id"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "password", property = "password")})
    List<Student> getAll();

    // ---------------------------- 分页 ----------------------------
    @Select("select * from Student " +
            "order by id desc limit #{0}, #{1}")
    List<Student> getByPage(int pageNum, int pageSize);

    @Select("select count(*) from Student")
    int getTotalRecordCounts();
    
}