package com.itheima.manger.service;

import com.itheima.manger.entity.Dept;
import com.itheima.manger.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpi implements DeptService {
@Autowired
private DeptMapper deptMapper;
public List<Dept> list(){
    deptMapper.selectAllDept();
    return deptMapper.selectAllDept();
}

    @Override
    public void delete(Integer id) {
//    Integer row  =deptMapper.delete(id);
//    System.out.println(row);
    deptMapper.delete(id);

    }

    @Override
    public void add(Dept dept) {
    dept.setCreateTime(LocalDateTime.now());
    dept.setUpdateTime(LocalDateTime.now());
    deptMapper.add(dept);

    }

    @Override
    public Dept find(Integer id) {

        return deptMapper.find(id);
    }

    @Override
    public void update(Dept dept) {
    dept.setUpdateTime(LocalDateTime.now());
    deptMapper.update(dept);







    }
}
