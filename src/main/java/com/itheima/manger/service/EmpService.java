package com.itheima.manger.service;

import com.itheima.manger.entity.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EmpService {
    PageBen page(EmpQueryParam  param);

    void add(Emp emp);

    void delete(List<Integer> ids);

    Emp getbyid(Integer id);

    void update(Emp emp);

    List<Emp> listForClazz();

    List<Empre> Getcount();

    Empvo Getjobcount();

    LoginQuery emplogin(Login login);

}
