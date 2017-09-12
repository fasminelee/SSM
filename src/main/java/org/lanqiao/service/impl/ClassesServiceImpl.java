package org.lanqiao.service.impl;

import org.lanqiao.dao.ClassesMapper;
import org.lanqiao.entity.Classes;
import org.lanqiao.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements BaseService<Classes> {

	@Autowired
	ClassesMapper mapper;

    @Override
    public boolean checkIsExist(Classes model) {
        return mapper.selectByPrimaryKey(model.getCid()) != null;
    }

    @Override
    public List<Classes> getByPage(int pageNum, int pageSize) {
        return mapper.getByPage(pageSize * (pageNum - 1), pageSize);
    }

    @Override
    public int getMaxPage(int pageSize) {
        int count = mapper.getTotalRecordCounts();
        return (count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
    }

    @Override
    public int add(Classes model) {
        return mapper.insert(model);
    }

    @Override
    public int deleteById(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Classes model) {
        return mapper.updateByPrimaryKey(model);
    }

    @Override
    public Classes getById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Classes> getAll() {
        return mapper.getAll();
    }
}
