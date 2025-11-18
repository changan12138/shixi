package com.itheima.manger.mapper;

import com.itheima.manger.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
     void deleteBatch(List<Integer> ids) ;

    List<Emp> page(EmpQueryParam param);
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp values (null,#{username},#{password},#{name},#{gender},#{phone},#{job}" +
            ",#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);


    Emp getbyid(Integer id);

    void update(Emp emp);

    List<Emp> listForClazz();

    List<Empre> Getcount();

    List<Empre> Getjobcount();

    LoginQuery emplogin(Login login);
}
