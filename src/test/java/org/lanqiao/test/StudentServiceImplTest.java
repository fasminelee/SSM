package org.lanqiao.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.lanqiao.service.impl.StudentServiceImpl;

public class StudentServiceImplTest {

    static StudentServiceImpl service;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        service = new StudentServiceImpl();
    }

    // ---------------------------- 分页 ----------------------------
    @Test
    public void testGetByPage() {
    }

    @Test
    public void testGetMaxPage() { }

    // ---------------------------- CRUD ----------------------------
    @Test
    public void testAdd() { }

    @Test
    public void testDeleteById() { }

    @Test
    public void testUpdate() { }

    @Test
    public void testGetById() { }

    @Test
    public void testGetAll() { }

}
