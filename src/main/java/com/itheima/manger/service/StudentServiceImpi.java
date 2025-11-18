package com.itheima.manger.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.manger.entity.*;
import com.itheima.manger.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpi implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageBen stupage(StudentQuery studentQuery) {
        PageHelper.startPage(studentQuery.getPage(), studentQuery.getPageSize());
        List<Student> studentList=studentMapper.stupage(studentQuery);
        Page ps = (Page) studentList;
        return new  PageBen(ps.getTotal(),studentList);
    }

    @Override
    public void studelete(List<Integer> ids) {
        studentMapper.studelete(ids);
    }

    @Override
    public void stuadd(Student student) {
        studentMapper.stuadd(student);

    }

    @Override
    public Student stuselect(Integer id) {
        Student student= studentMapper.stuselect(id);
        return student;
    }

    @Override
    public void stupdate(Student student) {
        studentMapper.stupate(student);
    }

    @Override
    public void stuvio(Integer id, Integer score) {
        studentMapper.stuvio(id,score);
    }

    @Override
    public List<Empre> studegree() {
        List<Empre> stu = studentMapper.studegree();
        return stu;
    }

    @Override
    public Stuvo stucount() {
        List<Empre> stuvos=studentMapper.stucount();
        Stuvo stucount=new Stuvo();
        List<String> clazzList=new ArrayList<>();
        List<Integer> dataList=new ArrayList<>();
        for (Empre empre:stuvos){
            clazzList.add(empre.getName());
            dataList.add(empre.getValue());
        }
        stucount.setClazzList(clazzList);
        stucount.setDataList(dataList);
        return   stucount;
    }
}
