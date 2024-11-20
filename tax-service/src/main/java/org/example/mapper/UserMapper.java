package org.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.domain.dto.UserDto;
import org.example.domain.po.User;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> ll();

    void insert(UserDto userDto);

    User querybynum(QueryWrapper<User> queryWrapper);
}
