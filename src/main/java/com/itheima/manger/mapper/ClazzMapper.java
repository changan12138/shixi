package com.itheima.manger.mapper;

import com.itheima.manger.entity.Clazz;
import com.itheima.manger.entity.ClazzQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> clazzpage(ClazzQuery clazzQuery);

    void clazzdelete(Integer id);

    void clazzsave(Clazz clazz);

    Clazz clazzselect(Integer id);

    void clazzupdate(Clazz clazz);

    List<Clazz> clazzlist();
}
