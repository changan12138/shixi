package com.itheima.manger.controller;

import com.itheima.manger.entity.*;
import com.itheima.manger.service.ClazzService;
import com.itheima.manger.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public Result studentspage(StudentQuery studentQuery){
        PageBen studentspage=studentService.stupage(studentQuery);
        return Result.success(studentspage);
    }

    @DeleteMapping("/students/{ids}")
    public Result studentdelete(@PathVariable List<Integer> ids){
        studentService.studelete(ids);
        return Result.success();

    }

    @PostMapping("/students")
    public Result studentadd(@RequestBody Student student){
        studentService.stuadd(student);
        return Result.success();
    }
    @GetMapping("/students/{id}")
    public Result stuselect(@PathVariable Integer id){
        Student student = studentService.stuselect(id);
        return Result.success(student);
    }
    @PutMapping("/students")
    public Result studentupdate(@RequestBody Student student){
        studentService.stupdate(student);
        return Result.success();
    }
    @PutMapping("/students/violation/{id}/{score}")
    public Result stuvio(@PathVariable Integer id, @PathVariable Integer score){
        studentService.stuvio(id,score);
        return Result.success();
    }
    @GetMapping("/report/studentDegreeData")
    public Result stuDegree() {
        List<Empre> stu = studentService.studegree();
        return Result.success(stu);
    }
    @GetMapping("/report/studentCountData")
    public Result stuCount() {
        Stuvo stu =studentService.stucount();
        return Result.success(stu);
    }


}








