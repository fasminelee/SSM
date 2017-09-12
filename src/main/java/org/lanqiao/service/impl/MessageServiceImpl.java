package org.lanqiao.service.impl;

import org.lanqiao.dao.MessageMapper;
import org.lanqiao.entity.Message;
import org.lanqiao.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements BaseService<Message> {

	@Autowired
	MessageMapper mapper;

    @Override
    public boolean checkIsExist(Message model) {
        return mapper.selectByPrimaryKey(model.getId()) != null;
    }

    @Override
    public List<Message> getByPage(int pageNum, int pageSize) {
        return mapper.getByPage(pageSize * (pageNum - 1), pageSize);
    }

    @Override
    public int getMaxPage(int pageSize) {
        int count = mapper.getTotalRecordCounts();
        return (count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
    }

    @Override
    public int add(Message model) {
        return mapper.insert(model);
    }

    @Override
    public int deleteById(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Message model) {
        return mapper.updateByPrimaryKey(model);
    }

    @Override
    public Message getById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Message> getAll() {
        return mapper.getAll();
    }
}
