package com.cxyxs.auto.service.impl;

import com.cxyxs.auto.entity.Student;
import com.cxyxs.auto.mapper.StudentMapper;
import com.cxyxs.auto.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序猿学社
 * @since 2020-04-05
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
