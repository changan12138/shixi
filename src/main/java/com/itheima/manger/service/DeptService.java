package com.itheima.manger.service;

import com.itheima.manger.entity.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    Dept find(Integer id);

    void update(Dept dept);
}
