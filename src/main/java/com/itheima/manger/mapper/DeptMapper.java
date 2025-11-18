package com.itheima.manger.mapper;

import com.itheima.manger.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface DeptMapper {
//    @Result(column = "create_time",property = "createTime")
    @Select("select id,name,create_time createTime ,update_time updateTime from dept")
    public List<Dept> selectAllDept();
    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);
//    Integer delete(Integer id);
    @Insert("insert into dept(name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);
    @Select("select * from dept  where id =#{id}")
    Dept find(Integer id);
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
