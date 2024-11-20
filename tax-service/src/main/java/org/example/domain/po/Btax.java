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
@TableName("btax")
public class Btax {      ///经营税收

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "create_time")
    private LocalDateTime createTime;   //
    private String usernum;                    //用户账号
    private String username;
    @TableField(value = "tax_type")
    private String taxType;       //税种
    @TableField(value = "tax_amount")
    private double taxAmount;    //税收金额
    @TableField(value = "nottax_amount")
    private double nottaxAmount;       //非税收金额
    @TableField(value = "reg_time")
    private LocalDateTime regTime;    //支付说明
    private String sfsh;            //审核
    private String shhf;        //审核回复
}
