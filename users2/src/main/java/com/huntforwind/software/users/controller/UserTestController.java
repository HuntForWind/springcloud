package com.huntforwind.software.users.controller;

import com.huntforwind.software.users.entity.UserTest;
import com.huntforwind.software.users.service.UserTestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户测试Controller
 */
@RestController
@RequestMapping("/user-test")
@Tag(name = "用户测试管理", description = "用户测试相关接口")
public class UserTestController {

    @Autowired
    private UserTestService userTestService;

    /**
     * 查询所有用户
     */
    @GetMapping("/list")
    @Operation(summary = "查询所有用户", description = "获取所有用户列表")
    public List<UserTest> list() {
        return userTestService.list();
    }

    /**
     * 根据ID查询用户
     */
    @GetMapping("/{id}")
    @Operation(summary = "根据ID查询用户", description = "根据用户ID获取用户信息")
    public UserTest getById(@Parameter(description = "用户ID", example = "1") @PathVariable Long id) {
        return userTestService.getById(id);
    }

    /**
     * 新增用户
     */
    @PostMapping
    @Operation(summary = "新增用户", description = "创建新用户")
    public boolean save(@RequestBody UserTest userTest) {
        return userTestService.save(userTest);
    }

    /**
     * 更新用户
     */
    @PutMapping
    @Operation(summary = "更新用户", description = "更新用户信息")
    public boolean update(@RequestBody UserTest userTest) {
        return userTestService.updateById(userTest);
    }

    /**
     * 根据ID删除用户
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户", description = "根据ID删除用户（逻辑删除）")
    public boolean delete(@Parameter(description = "用户ID", example = "1") @PathVariable Long id) {
        return userTestService.removeById(id);
    }
}
