package com.itheima.manger.controller;

import com.itheima.manger.entity.*;
import com.itheima.manger.service.EmpService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
public class EmpContorller {
    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result page(EmpQueryParam param){
        log.info("分页查询:{},{},{},{},{},{}",param.getName(),param.getGender(),param.getBegin()
                ,param.getEnd(), param.getPage(), param.getPageSize());
        PageBen pageBen=empService.page(param);
        return Result.success(pageBen);
    }
    @PostMapping("/emps")
    public Result addEmp(@RequestBody Emp emp){
        log.info("新增员工：{}",emp);
        empService.add(emp);
        return Result.success();
    }
    @DeleteMapping("/emps")
    public Result deleteEmp(@RequestParam List<Integer> ids){
        log.info("删除员工");
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/emps/{id}")
    public Result getbyid(@PathVariable Integer id){
        Emp emp= empService.getbyid(id);
        return Result.success(emp);
    }
    @PutMapping("/emps")
    public Result updateEmp(@RequestBody Emp emp){
        empService.update(emp);
        return Result.success();
    }@GetMapping("/emps/list")
    public Result listForClazz() {
        // 查出可作为班主任的员工
        List<Emp> list = empService.listForClazz();
        return Result.success(list);
    }

    @GetMapping("/report/empGenderData")
    public Result reportEmpGenderData() {
        List<Empre> list = empService.Getcount();
        return Result.success(list);
    }

    @GetMapping("/report/empJobData")
    public Result reportEmpJobData() {

        return Result.success(empService.Getjobcount());
    }
    @PostMapping("/login")
    public Result login(@RequestBody Login login) {
        LoginQuery loginQuery = empService.emplogin(login);
        if (loginQuery != null) {
            return Result.success(loginQuery);
        } else {
            return Result.error("登录失败 账号或密码有误");
        }
    }


}
