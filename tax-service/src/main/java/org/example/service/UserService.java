package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.common.Result;
import org.example.domain.dto.UserDto;
import org.example.domain.po.User;

import java.util.List;

public interface UserService extends IService<User> {

   List<User> ll();

    Result<String> register(UserDto userDto);

    UserDto querybynum(String userNum);


    Result<String> insert(UserDto userDto);

    String token(UserDto user);

    void updateUser(UserDto userDto, String usernum);

 void delete(String userNum);
}
