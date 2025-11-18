package com.itheima.manger.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.manger.aop.Log;
import com.itheima.manger.entity.Clazz;
import com.itheima.manger.entity.ClazzQuery;
import com.itheima.manger.entity.PageBen;
import com.itheima.manger.entity.Student;
import com.itheima.manger.mapper.ClazzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpi implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Log
    @Override
    public PageBen clazzpage(ClazzQuery clazzQuery) {
        PageHelper.startPage(clazzQuery.getPage(), clazzQuery.getPageSize());
        List<Clazz> p =clazzMapper.clazzpage(clazzQuery);
        Page page = (Page) p;
        return new PageBen(page.getTotal(),p);
    }

    @Override
    public void clazzdelete(Integer id) {
        clazzMapper.clazzdelete(id);
    }

    @Override
    public void clazzsave(Clazz clazz) {
        clazzMapper.clazzsave(clazz);
    }

    @Override
    public Clazz clazzselect(Integer id) {
        Clazz clazz = clazzMapper.clazzselect(id);
        return clazz;
    }

    @Override
    public void clazzupdate(Clazz clazz) {
        clazzMapper.clazzupdate(clazz);
    }

    @Override
    public List<Clazz> clazzlist() {
        List<Clazz> clazzList =clazzMapper.clazzlist();
        return  clazzList;
    }
}
