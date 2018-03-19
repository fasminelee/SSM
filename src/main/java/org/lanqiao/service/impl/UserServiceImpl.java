package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.UserMapper;
import org.lanqiao.entity.User;
import org.lanqiao.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements BaseService<User> {

	@Autowired
	UserMapper mapper;

    @Override
    public boolean checkIsExist(User model) {
        return mapper.selectByPrimaryKey(model.getId()) != null;
    }

    @Override
    public List<User> getByPage(int pageNum, int pageSize) {
        return mapper.getByPage(pageSize * (pageNum - 1), pageSize);
    }

    @Override
    public int getMaxPage(int pageSize) {
        int count = mapper.getTotalRecordCounts();
        return (count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
    }

    @Override
    public int add(User model) {
        return mapper.insert(model);
    }

    @Override
    public int deleteById(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(User model) {
        return mapper.updateByPrimaryKey(model);
    }

    @Override
    public User getById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getAll() {
        return mapper.getAll();
    }

}
