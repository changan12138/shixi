package com.itheima.manger.controller;

import com.itheima.manger.entity.Dept;
import com.itheima.manger.entity.Result;
import com.itheima.manger.service.DeptService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequestMapping("/depts")
@RestController     //等价于@Controller+@ResponseBody
public class DeptController {
@Autowired
//    @Resource(name = "DeptServiceImpi")
    private DeptService deptService;

    /**
     * 获取部门列表
     * @return
     */
    @GetMapping
    public Result list(){
        //1.调用service，获取数据
        List<Dept> depts = deptService.list();

        //3.响应数据（json格式）
        return Result.success(depts);
    }
//    @RequestMapping(value = "/depts",method = RequestMethod.DELETE)
    @DeleteMapping
    public Result delete(@RequestParam(value = "id",required = false) Integer id){
        log.info("id={}",id);
        //调用servce的删除方法
        deptService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Dept dept){
        log.info("添加部门" ,dept);
        deptService.add(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result find(@PathVariable Integer id){
        log.info("查询",id);
        Dept dept = deptService.find(id);
        return Result.success(dept);
    }
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("更新",dept);
        deptService.update(dept);
        return Result.success();
    }
}

