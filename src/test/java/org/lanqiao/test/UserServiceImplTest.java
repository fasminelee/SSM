package org.lanqiao.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.lanqiao.service.impl.UserServiceImpl;

public class UserServiceImplTest {

    static UserServiceImpl service;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        service = new UserServiceImpl();
    }

    // ---------------------------- 分页 ----------------------------
    @Test
    public void testGetByPage() {
    }

    @Test
    public void testGetMaxPage() {
        service.getMaxPage(2);
    }

    // ---------------------------- CRUD ----------------------------
    @Test
    public void testAdd() {
    }

    @Test
    public void testDeleteById() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testGetById() {
        service.getById(1);
    }

    @Test
    public void testGetAll() {
        service.getAll();
    }
}
