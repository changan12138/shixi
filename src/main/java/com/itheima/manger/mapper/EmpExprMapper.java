package com.itheima.manger.mapper;

import com.itheima.manger.entity.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmpExprMapper {
    void deleteBatch(List<Integer> empIds) ;

    void insertBatch(List<EmpExpr> exprList);

    void deletebyid(Integer id);
}
