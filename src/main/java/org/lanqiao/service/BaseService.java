package org.lanqiao.service;

import java.util.List;

public interface BaseService<E> {

    public boolean checkIsExist(E model);

    // ---------------------------- 分页 ----------------------------
    public List<E> getByPage(int pageNum, int pageSize);

    public int getMaxPage(int pageSize);

    // ---------------------------- CRUD ----------------------------
    public int add(E model);

    public int deleteById(int id);

    public int update(E model);

    public E getById(int id);

    public List<E> getAll();
}
