package org.example.service.impl;

import cn.hutool.core.bean.BeanUtil;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.common.Result;
import org.example.domain.dto.UserDto;
import org.example.domain.po.User;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.example.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> ll() {
        return userMapper.ll();
    }

    @Override
    public Result register(UserDto userDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("usernum", userDto.getUserNum());
        User user = userMapper.selectOne(queryWrapper);
        if(user != null){
            return Result.error("用户已存在");
        }
        User user1 = BeanUtil.copyProperties(userDto, User.class);
        userMapper.insert(user1);

        return Result.success();
    }

    @Override
    public UserDto querybynum(String userNum) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("usernum", userNum);
        User user = userMapper.selectOne(queryWrapper);
        return BeanUtil.copyProperties(user, UserDto.class);
    }

    @Override
    public Result<String> insert(UserDto userDto) {

        userDto.setCreateTime(now());
        userMapper.insert(BeanUtil.copyProperties(userDto, User.class));

        return Result.success();
    }

    @Override
    public String token(UserDto user) {
        Map<String, Object> map = new HashMap<>();
        map.put("userNum", user.getUserNum());
        return JwtUtil.CreateToken(map);
    }

    @Override
    public void updateUser(UserDto userDto, String usernum) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("usernum", usernum);
        User user = BeanUtil.copyProperties(userDto, User.class);
        userMapper.update(user, queryWrapper);
    }

    @Override
    public void delete(String userNum) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("usernum", userNum);
        userMapper.delete(queryWrapper);
    }
}
