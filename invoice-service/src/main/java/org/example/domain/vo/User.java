package org.example.domain.vo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class User {

    private int id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")

    private LocalDateTime createTime;

    private String userNum;

    private String username;

    private String password;

    private String sex;

    private String mail;

    private String phone;

    private String age;

    private String identity;

    private String pic;


}
