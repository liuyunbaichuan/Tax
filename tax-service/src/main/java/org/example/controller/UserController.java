package org.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.Result;
import org.example.domain.dto.UserDto;
import org.example.domain.po.User;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.example.utils.PageUtils;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/userList")
    public List<User> list(){
        List<User> list = userService.list();
        return list;
    }

    @GetMapping
    public PageUtils<User> userList(int pageSize, int pageNum){
        Page<User> page = new Page<>(pageNum, pageSize);

        IPage<User> userIPage = userService.page(page);

        return PageUtils.page(userIPage);
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserDto userDto){
        UserDto dto = userService.querybynum(userDto.getUserNum());
        if(dto != null){
            return Result.error("用户已存在");
        }

        return userService.insert(userDto);
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserDto userDto){
        UserDto user = userService.querybynum(userDto.getUserNum());
        if(user == null || !user.getPassword().equals(userDto.getPassword())){
            return Result.error("用户错误或密码错误");
        }
        String token = userService.token(user);
        return Result.success(token);
    }

    
    @PostMapping("/update")
    public Result update(@RequestBody UserDto userDto){
        String usernum = ThreadLocalUtil.get();
        userService.updateUser(userDto,usernum);
        return Result.success("修改成功");
    }

    @GetMapping("/delete")
    public Result delete(String userNum){
        userService.delete(userNum);
        return Result.success("操作成功");
    }
}
