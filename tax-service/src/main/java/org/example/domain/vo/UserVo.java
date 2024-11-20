package org.example.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {


    private String userNum;
    private String username;
    private String sex;
    private String mail;
    private String phone;
    private String age;
    private String identity;
}
