package org.example.domain.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName("user")
public class User {
    @TableId(type= IdType.AUTO)
    private int id;
    @TableField(value = "create_time")
    private LocalDateTime createTime;
    @TableField(value = "usernum")
    private String userNum;
    @TableField(value = "username")
    private String username;
    @TableField(value = "password")
    private String password;
    @TableField(value = "sex")
    private String sex;
    @TableField(value = "age")
    private String mail;
    @TableField(value = "mail")
    private String phone;
    @TableField(value = "phone")
    private String age;
    @TableField(value = "identity")
    private String identity;
    @TableField(value = "pic")
    private String pic;


}
