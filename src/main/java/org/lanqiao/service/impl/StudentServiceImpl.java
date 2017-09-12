package org.lanqiao.service.impl;

import org.lanqiao.dao.StudentMapper;
import org.lanqiao.entity.Student;
import org.lanqiao.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements BaseService<Student> {

	@Autowired
	StudentMapper mapper;

    @Override
    public boolean checkIsExist(Student model) {
        return mapper.selectByPrimaryKey(model.getSid()) != null;
    }

    @Override
    public List<Student> getByPage(int pageNum, int pageSize) {
        return mapper.getByPage(pageSize * (pageNum - 1), pageSize);
    }

    @Override
    public int getMaxPage(int pageSize) {
        int count = mapper.getTotalRecordCounts();
        return (count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
    }

    @Override
    public int add(Student model) {
        return mapper.insert(model);
    }

    @Override
    public int deleteById(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Student model) {
        return mapper.updateByPrimaryKey(model);
    }

    @Override
    public Student getById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> getAll() {
        return mapper.getAll();
    }

   
}
