package com.itheima.manger.service;

import com.itheima.manger.entity.Clazz;
import com.itheima.manger.entity.ClazzQuery;
import com.itheima.manger.entity.PageBen;

import java.util.List;

public interface ClazzService {
    PageBen clazzpage(ClazzQuery clazzQuery) ;

    void clazzdelete(Integer id);

    void clazzsave(Clazz clazz);

    Clazz clazzselect(Integer id);

    void clazzupdate(Clazz clazz);

    List<Clazz> clazzlist();
}
