package com.itheima.manger.mapper;

import com.itheima.manger.entity.Empre;
import com.itheima.manger.entity.Student;
import com.itheima.manger.entity.StudentQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> stupage(StudentQuery studentQuery);

    void studelete(List<Integer> ids);

    void stuadd(Student student);

    Student stuselect(Integer id);

    void stupate(Student student);

    void stuvio(Integer id, Integer score);

    List<Empre> studegree();

    List<Empre> stucount();
}
