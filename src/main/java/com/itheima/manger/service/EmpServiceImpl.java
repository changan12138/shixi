package com.itheima.manger.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.manger.entity.*;
import com.itheima.manger.mapper.EmpExprMapper;
import com.itheima.manger.mapper.EmpMapper;
import com.itheima.manger.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public PageBen page(EmpQueryParam param) {
//        Long total =empMapper.count();
//        Integer start = (page-1)*pageSize;
//        List<Emp> empList=empMapper.page(start,pageSize);
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Emp> empList = empMapper.page(param);
        Page p = (Page) empList;
        return new PageBen(p.getTotal(), empList);
    }
    @Transactional
    @Override
    public void add(Emp emp) {
        emp.setPassword("123456");
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
        Integer id = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(x -> {
                x.setEmpId(id);
            });
            empExprMapper.insertBatch(exprList);
        }
    }
    @Transactional
    @Override
    public void delete(List<Integer> ids) {
       empMapper.deleteBatch(ids);
        empExprMapper.deleteBatch(ids);
    }

    @Override
    public Emp getbyid(Integer id) {
          return empMapper.getbyid(id);

    }
@Transactional
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
        empExprMapper.deletebyid(emp.getId());
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(x -> {x.setEmpId(emp.getId());});
            empExprMapper.insertBatch(exprList);
        }

    }

    @Override
    public List<Emp> listForClazz() {
        return empMapper.listForClazz();
    }

    @Override
    public List<Empre> Getcount() {
        return empMapper.Getcount();

    }

    @Override
    public Empvo Getjobcount() {
        List<Empre> empList = empMapper.Getjobcount();
        List<String> jobList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        for (Empre emp : empList) {
            jobList.add(emp.getName());
            dataList.add(emp.getValue());
        }
         Empvo empvo = new Empvo();
        empvo.setJobList(jobList);
        empvo.setDataList(dataList);
        return empvo;
    }

    @Override
    public LoginQuery emplogin(Login login) {
        LoginQuery loginQuery =empMapper.emplogin(login);
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",loginQuery.getId());
        claims.put("username",loginQuery.getUsername());
        loginQuery.setToken(JwtUtils.generateJwt(claims));


        return loginQuery;
    }
}
