package org.example.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userNum;
    private String password;
    private String username;
    private LocalDateTime createTime;
    private String sex;
    private String mail;
    private String phone;
    private String age;
    private String identity;
    private String pic;

}
