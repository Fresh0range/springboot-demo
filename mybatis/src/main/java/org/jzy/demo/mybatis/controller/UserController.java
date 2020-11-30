package org.jzy.demo.mybatis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jzy.demo.mybatis.entity.User;
import org.jzy.demo.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "用户操作接口")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @ApiOperation(value = "查询所有用户")
    @GetMapping
    public List<User> listAll() {
        return service.listAll();
    }

    @ApiOperation(value = "根据用户编号查询用户")
    // 类型转换 string-->int
    @ApiImplicitParam(name = "id", value = "用户编号", required = true, paramType = "path", dataType = "int")
    @GetMapping("{id}")
    public User get(@PathVariable Integer id) {
        return service.get(id);
    }

    @ApiOperation(value = "新建用户")
    @ApiParam(name = "user", value = "用户", required = true)
    @PostMapping
    public User post(@RequestBody User user) {
        return service.post(user);
    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "id", value = "用户编号", required = true, paramType = "path", dataType = "int")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @ApiOperation(value = "修改用户")
    @ApiParam(name = "user", value = "用户", required = true)
    @PutMapping
    public User put(@RequestBody User user) {
        return service.put(user);
    }
}
