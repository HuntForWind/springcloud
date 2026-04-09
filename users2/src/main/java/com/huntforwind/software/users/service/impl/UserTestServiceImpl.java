package com.huntforwind.software.users.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huntforwind.software.users.entity.UserTest;
import com.huntforwind.software.users.mapper.UserTestMapper;
import com.huntforwind.software.users.service.UserTestService;
import org.springframework.stereotype.Service;

/**
 * 用户测试Service实现类
 */
@Service
public class UserTestServiceImpl extends ServiceImpl<UserTestMapper, UserTest> implements UserTestService {
}
