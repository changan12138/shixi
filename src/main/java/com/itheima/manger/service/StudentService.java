package com.itheima.manger.service;

import com.itheima.manger.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    PageBen stupage(StudentQuery studentQuery);

    void studelete(List<Integer> ids);

    void stuadd(Student student);

    Student stuselect(Integer id);

    void stupdate(Student student);

    void stuvio(Integer id, Integer score);

    List<Empre> studegree();

    Stuvo stucount();
}
