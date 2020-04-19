package com.cxyxs.auto.controller;


import com.cxyxs.auto.entity.Student;
import com.cxyxs.auto.mapper.StudentMapper;
import com.cxyxs.auto.util.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 程序猿学社
 * @since 2020-04-05
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/test")
    @ApiOperation(value = "测试接口",notes = "测试")
    public List<Student> getStudent1(Student stu){
        List<Student> lists = studentMapper.selectList(null);
        return lists;
    }
}

