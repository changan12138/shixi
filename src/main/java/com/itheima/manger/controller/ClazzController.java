package com.itheima.manger.controller;

import com.itheima.manger.entity.Clazz;
import com.itheima.manger.entity.ClazzQuery;
import com.itheima.manger.entity.PageBen;
import com.itheima.manger.entity.Result;
import com.itheima.manger.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping("/clazzs")
    public Result clazzpage(ClazzQuery clazzQuery){
        log.info("班级分页查询：{},{},{},{},{}",clazzQuery.getName(),clazzQuery.getBegin(),clazzQuery.getEnd(),
        clazzQuery.getPage(),clazzQuery.getPageSize());
        PageBen clazzpageben = clazzService.clazzpage(clazzQuery);
        return Result.success(clazzpageben);
    }

    @DeleteMapping("/clazzs/{id}")
    public Result clazzdelete(@PathVariable Integer id){
        log.info("删除班级：{}",id);
        clazzService.clazzdelete(id);
        return Result.success();
    }
    @PostMapping("/clazzs")
    public Result clazzsave(@RequestBody Clazz clazz){
        log.info("添加班级:{},{},{},{},{},{}",clazz.getName(),clazz.getRoom()
        ,clazz.getBeginDate(),clazz.getEndDate(),clazz.getMasterId(),clazz.getSubject());
        clazzService.clazzsave(clazz);
        return Result.success();
    }
    @GetMapping("/clazzs/{id}")
    public Result clazzselect(@PathVariable Integer id){
        Clazz clazz = clazzService.clazzselect(id);
        return Result.success(clazz);
    }
    @PutMapping("/clazzs")
    public Result clazzupdate(@RequestBody Clazz clazz){
        clazzService.clazzupdate(clazz);
        return Result.success();
    }
    @GetMapping("/clazzs/list")
    public Result clazzlist(){
        List<Clazz>clazzList= clazzService.clazzlist();
        return Result.success(clazzList);
    }

}
