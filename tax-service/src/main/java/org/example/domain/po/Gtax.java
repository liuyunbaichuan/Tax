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
@TableName("gtax")
public class Gtax {    //个税

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "create_time")
    private LocalDateTime createTime;   //
    @TableField(value = "applynum")
    private String applyNum;         //申请编号
    @TableField(value = "tax_project")
    private String taxProject;       //退税项目
    @TableField(value = "tax_num")
    private double taxNum;       //退税金额
    private String bank;    //银行账号
    private String userNum;      //用户账号
    private double username;       //
    private String phone;    //
    private String identity;      //身份证
    private String sfsh;            //审核
    private String shhf;        //审核回复
}
