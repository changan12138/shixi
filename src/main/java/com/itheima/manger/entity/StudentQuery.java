package com.itheima.manger.entity;

import lombok.Data;

@Data
public class StudentQuery {
    private String name; //姓名
    private Integer degree; //最高学历,
    private Integer clazzId; //班级ID
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数

}
